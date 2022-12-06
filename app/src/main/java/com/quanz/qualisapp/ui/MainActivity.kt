package com.quanz.qualisapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.quanz.qualisapp.R
import com.quanz.qualisapp.repository.QualisRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repository: QualisRepository = QualisRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllinformacoes()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_qualis, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.botao_atualizar -> {
                getAllinformacoes()
                true
            }
            else -> false
        }
    }

    private fun getAllinformacoes() {
        lifecycleScope.launch {
            repository.getPeriodico()
            repository.getConferencia()
            repository.getCorrelacoes()
        }
    }

    private fun renderizaLista(){
        // TODO: Recuperar informações do repository
    }

    companion object {
        const val BASE_URL = "https://qualis.ic.ufmt.br/"
        const val DATABASE_NAME = "DATABASE_NAME"
    }
}