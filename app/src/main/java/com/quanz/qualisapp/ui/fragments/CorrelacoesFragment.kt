package com.quanz.qualisapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.quanz.qualisapp.adapters.ConferenciasAdapter
import com.quanz.qualisapp.adapters.CorrelacoesAdapter
import com.quanz.qualisapp.databinding.FragmentCorrelacoesBinding
import com.quanz.qualisapp.repository.QualisRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CorrelacoesFragment : Fragment() {

    @Inject
    lateinit var repository: QualisRepository

    private var _binding: FragmentCorrelacoesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCorrelacoesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCorrelacoes()
    }

    private fun getCorrelacoes() {
        lifecycleScope.launch {

            val correlacoesList = repository.recuperaCorrelacoes()

            binding.lista.adapter = CorrelacoesAdapter(correlacoesList)
        }
    }

}