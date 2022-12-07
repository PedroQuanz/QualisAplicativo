package com.quanz.qualisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.quanz.qualisapp.databinding.ItemCorrelacaoBinding

class CorrelacoesAdapter(private val correlacoesList: List<List<String>>):
    RecyclerView.Adapter<CorrelacoesAdapter.CorrelacoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorrelacoesViewHolder {

        return CorrelacoesViewHolder(
            ItemCorrelacaoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: CorrelacoesViewHolder, position: Int) {

        val correlacao = correlacoesList[position]

        with(holder.itemBinding) {
            texto0.text = correlacao[0]
            texto1.text = correlacao[1]
            texto2.text = correlacao[2]
            texto3.text = correlacao[3]
            texto4.text = correlacao[4]
        }
    }

    override fun getItemCount(): Int = correlacoesList.size

    inner class CorrelacoesViewHolder(val itemBinding: ItemCorrelacaoBinding) :
        ViewHolder(itemBinding.root)
}