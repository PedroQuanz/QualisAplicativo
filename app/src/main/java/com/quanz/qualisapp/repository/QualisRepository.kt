package com.quanz.qualisapp.repository

import android.content.Context
import androidx.room.Room
import com.quanz.qualisapp.db.QualisDatabase
import com.quanz.qualisapp.service.QualisAppService
import com.quanz.qualisapp.ui.MainActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QualisRepository(
    context: Context
) {

    private val service: QualisAppService = montaRetrofit().create(QualisAppService::class.java)

    private val qualisDatabase =
        Room.databaseBuilder(
            context, QualisDatabase::class.java, MainActivity.DATABASE_NAME
        ).build()

    enum class FonteDeDados{
        CONFERENCIAS,
        PERIODICO,
        CORRELACOES
    }

    suspend fun getConferencias(){
        val conferencias = recuperaInformacoes(FonteDeDados.CONFERENCIAS)
    }

    private suspend fun recuperaInformacoes(fonteDeDados: FonteDeDados): List<List<String>> {
        return when(fonteDeDados){
            FonteDeDados.CONFERENCIAS -> service.getConferencias().conferencia
            FonteDeDados.PERIODICO -> service.getPeriodicos().periodico
            FonteDeDados.CORRELACOES -> service.getCorrelacoes().correlacoes
        }

    }

//    suspend fun getPeriodico() {
//        qualisTable().selectAllPeriodicos()
//        val periodicos = service.getPeriodicos()
//        savePeriodico(periodicos.periodico)
    }

//    suspend fun getConferencia(): List<List<String>> {
//        val conferencias = qualisTable().selectAllConferencias()
//        if (conferencias.isEmpty()) {
//            val confs = service.getConferencias()
//            saveConferencia(confs.conferencia)
//            return confs.conferencia
//        }
//        return conferencias.map {
//            listOf(it.siglas, it.nome, it.extratoCapes)
//        }
//    }

//    suspend fun getCorrelacoes() {
//        val correlacoes = service.getCorrelacoes()
//            saveCorrelacoes(correlacoes.correlacaoComOutrasAreas)
//    }

//    private suspend fun saveCorrelacoes(correlacoes: List<List<String>>) {
//        for (correlacao in correlacoes) {
//            qualisTable().insertCorrelacaoComOutraArea(
//                CorrelacaoComOutraAreaEntity(
//                    issn = correlacao[0],
//                    periodico = correlacao[1],
//                    extratoCapesComp = correlacao[2],
//                    extratoCapes = correlacao[3],
//                    area = correlacao[4]
//                )
//            )
//        }
//    }

//    private suspend fun savePeriodico(periodicos: List<List<String>>) {
//        for (periodico in periodicos) {
//            qualisTable().insertPeriodico(
//                PeriodicoEntity(
//                    issn = periodico[0],
//                    nome = periodico[1],
//                    extratoCapes = periodico[2]
//                )
//            )
//        }
//    }

    private fun montaRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MainActivity.BASE_URL)
            .build()
    }

//    private fun qualisTable() = qualisDatabase.qualisDao()
