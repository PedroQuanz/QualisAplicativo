package com.quanz.qualisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.quanz.qualisapp.databinding.ItemPeriodicoBinding
import com.quanz.qualisapp.databinding.ItemTresColunasBinding

/**
 * Adapters são responsáveis por adaptar os dados para um viewHolder
 */
class PeriodicosAdapter(private val periodicosList: List<List<String>>) :
    RecyclerView.Adapter<PeriodicosAdapter.PeriodicosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeriodicosViewHolder {

        return PeriodicosViewHolder(
            ItemTresColunasBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PeriodicosViewHolder, position: Int) {

        val periodico = periodicosList[position]

        with(holder.itemBinding) {
            txtColunaUm.text = periodico[0]
            txtColunaDois.text = periodico[1]
            txtColunaTres.text = periodico[2]
        }
    }

    override fun getItemCount(): Int = periodicosList.size

    inner class PeriodicosViewHolder(val itemBinding: ItemTresColunasBinding) :
        ViewHolder(itemBinding.root)
}