package com.quanz.qualisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.quanz.qualisapp.databinding.ItemConferenciaBinding

class ConferenciasAdapter(private val conferenciasList: List<List<String>>) :
    RecyclerView.Adapter<ConferenciasAdapter.ConferenciasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.quanz.qualisapp.adapters.ConferenciasAdapter.ConferenciasViewHolder {

        return ConferenciasViewHolder(
            ItemConferenciaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ConferenciasAdapter.ConferenciasViewHolder, position: Int) {

        val conferencia = conferenciasList[position]

        with(holder.itemBinding) {
            texto0.text = conferencia[0]
            texto1.text = conferencia[1]
            texto2.text = conferencia[2]
        }
    }
    override fun getItemCount(): Int = conferenciasList.size

    inner class ConferenciasViewHolder(val itemBinding: ItemConferenciaBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}