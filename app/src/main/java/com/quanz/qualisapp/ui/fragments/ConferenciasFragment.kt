package com.quanz.qualisapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.quanz.qualisapp.adapters.ConferenciasAdapter
import com.quanz.qualisapp.databinding.FragmentConferenciasBinding
import com.quanz.qualisapp.repository.QualisRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ConferenciasFragment : Fragment() {

    @Inject
    lateinit var repository: QualisRepository

    private var _binding: FragmentConferenciasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConferenciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getConferencias()
    }

    private fun getConferencias() {
        lifecycleScope.launch {

            val conferenciasList = repository.recuperaConferencias()

            binding.lista.adapter = ConferenciasAdapter(conferenciasList)
        }
    }


}