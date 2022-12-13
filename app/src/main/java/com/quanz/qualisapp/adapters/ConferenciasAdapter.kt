package com.quanz.qualisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.quanz.qualisapp.databinding.ItemTresColunasBinding

class ConferenciasAdapter(private val conferenciasList: List<List<String>>) :
    RecyclerView.Adapter<ConferenciasAdapter.ConferenciasViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConferenciasAdapter.ConferenciasViewHolder {

        return ConferenciasViewHolder(
            ItemTresColunasBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ConferenciasAdapter.ConferenciasViewHolder,
        position: Int
    ) {

        val conferencia = conferenciasList[position]

        with(holder.itemBinding) {
            txtColunaUm.text = conferencia[0]
            txtColunaDois.text = conferencia[1]
            txtColunaTres.text = conferencia[2]
        }
    }

    override fun getItemCount(): Int = conferenciasList.size

    inner class ConferenciasViewHolder(val itemBinding: ItemTresColunasBinding) :
        ViewHolder(itemBinding.root)
}