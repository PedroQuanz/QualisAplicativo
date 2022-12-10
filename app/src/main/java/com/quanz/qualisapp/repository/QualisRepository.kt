package com.quanz.qualisapp.repository

import android.content.Context
import androidx.room.Room
import com.quanz.qualisapp.db.QualisDatabase
import com.quanz.qualisapp.db.entities.ConferenciaEntity
import com.quanz.qualisapp.db.entities.CorrelacaoComOutraAreaEntity
import com.quanz.qualisapp.db.entities.PeriodicoEntity
import com.quanz.qualisapp.service.QualisAppService
import com.quanz.qualisapp.ui.MainActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QualisRepository(
    private val context: Context
) {

    private val service: QualisAppService = montaRetrofit().create(QualisAppService::class.java)

    private val qualisDatabase =
        Room.databaseBuilder(
            context, QualisDatabase::class.java, MainActivity.DATABASE_NAME
        ).build()

    suspend fun getPeriodico() {
            qualisTable().selectAllPeriodicos()
        val periodicos = service.getPeriodicos()
        savePeriodico(periodicos.periodico)
    }

    suspend fun getConferencia():List<List<String>> {
        val conferencias = qualisTable().selectAllConferencias()
        if (conferencias.isEmpty()){
            val confs = service.getConferencias()
            saveConferencia(confs.conferencia)
            return confs.conferencia
        }
        return conferencias.map {
            listOf(it.siglas, it.nome, it.extratoCapes)
        }
    }

    suspend fun getCorrelacoes() {
            val correlacoes = service.getCorrelacaoOutrasAreas()
            saveCorrelacoes(correlacoes.correlacaoComOutrasAreas)
    }

    private suspend fun saveCorrelacoes(correlacoes: List<List<String>>) {
        for (correlacao in correlacoes) {
            qualisTable().insertCorrelacaoComOutraArea(
                CorrelacaoComOutraAreaEntity(
                    issn = correlacao[0],
                    periodico = correlacao[1],
                    extratoCapesComp = correlacao[2],
                    extratoCapes = correlacao[3],
                    area = correlacao[4]
                )
            )
        }
    }

    private suspend fun saveConferencia(conferencias: List<List<String>>) {
        for (conferencia in conferencias) {
            qualisTable().insertConferencia(
                ConferenciaEntity(
                    siglas = conferencia[0],
                    nome = conferencia[1],
                    extratoCapes = conferencia[2]
                )
            )
        }
    }

    private suspend fun savePeriodico(periodicos: List<List<String>>) {
        for (periodico in periodicos) {
            qualisTable().insertPeriodico(
                PeriodicoEntity(
                    issn = periodico[0],
                    nome = periodico[1],
                    extratoCapes = periodico[2]
                )
            )
        }
    }

    private fun montaRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MainActivity.BASE_URL)
            .build()
    }

    private fun qualisTable() = qualisDatabase.qualisDao()

}