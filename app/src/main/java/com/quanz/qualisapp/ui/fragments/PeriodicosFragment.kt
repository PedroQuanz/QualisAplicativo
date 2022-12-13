package com.quanz.qualisapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.quanz.qualisapp.adapters.CorrelacoesAdapter
import com.quanz.qualisapp.adapters.PeriodicosAdapter
import com.quanz.qualisapp.databinding.FragmentPeriodicosBinding
import com.quanz.qualisapp.repository.QualisRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PeriodicosFragment : Fragment() {

    @Inject
    lateinit var repository: QualisRepository

    private var _binding: FragmentPeriodicosBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPeriodicosBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPeriodicos()
    }

    private fun getPeriodicos() {
        lifecycleScope.launch {

            val periodicosList = repository.recuperaPeriodicos()

            binding.lista.adapter = PeriodicosAdapter(periodicosList)
        }
    }
}
