package com.quanz.qualisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.quanz.qualisapp.databinding.ItemDuasColunasBinding

class CorrelacoesAdapter(private val correlacoesList: List<List<String>>) :
    RecyclerView.Adapter<CorrelacoesAdapter.CorrelacoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorrelacoesViewHolder {

        return CorrelacoesViewHolder(
            ItemDuasColunasBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: CorrelacoesViewHolder, position: Int) {

        val correlacao = correlacoesList[position]

        with(holder.itemBinding) {
            txtColunaUm.text = correlacao[0]
            txtColunaUm.text = correlacao[1]
        }
    }

    override fun getItemCount(): Int = correlacoesList.size

    inner class CorrelacoesViewHolder(val itemBinding: ItemDuasColunasBinding) :
        ViewHolder(itemBinding.root)
}