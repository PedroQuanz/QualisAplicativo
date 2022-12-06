package com.quanz.qualisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.quanz.qualisapp.databinding.ItemPeriodicoBinding

/**
 * Adapters são responsáveis por adaptar os dados para um viewHolder
 */
class PeriodicosAdapter(private val periodicosList: List<List<String>>) :
    RecyclerView.Adapter<PeriodicosAdapter.PeriodicosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeriodicosViewHolder {

        return PeriodicosViewHolder(
            ItemPeriodicoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PeriodicosViewHolder, position: Int) {

        val periodico = periodicosList[position]

        with(holder.itemBinding) {
            texto0.text = periodico[0]
            texto1.text = periodico[1]
            texto2.text = periodico[2]
        }
    }

    override fun getItemCount(): Int = periodicosList.size

    inner class PeriodicosViewHolder(val itemBinding: ItemPeriodicoBinding) :
        ViewHolder(itemBinding.root)
}