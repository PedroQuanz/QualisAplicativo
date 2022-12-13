package com.quanz.qualisapp.repository

import com.quanz.qualisapp.adapters.ConferenciasAdapter
import com.quanz.qualisapp.adapters.CorrelacoesAdapter
import com.quanz.qualisapp.adapters.PeriodicosAdapter
import com.quanz.qualisapp.db.QualisDatabase
import com.quanz.qualisapp.db.entities.ConferenciaEntity
import com.quanz.qualisapp.db.entities.CorrelacoesEntity
import com.quanz.qualisapp.db.entities.PeriodicoEntity
import com.quanz.qualisapp.service.QualisAppService
import com.quanz.qualisapp.service.models.ConferenciasData
import com.quanz.qualisapp.service.models.CorrelacoesData
import com.quanz.qualisapp.service.models.PeriodicosData
import javax.inject.Inject


interface QualisRepository {
    suspend fun getConferencias():ConferenciasData
    suspend fun getPeriodicos(): PeriodicosData
    suspend fun getCorrelacoes(): CorrelacoesData

    suspend fun salvaConferencias(conferencias: ConferenciasData)
    suspend fun salvaCorrelacoes(correlacoes: CorrelacoesData)
    suspend fun salvaPeriodicos(periodico: PeriodicosData)

    suspend fun atualizarTudo()

    // TODO: PEDRO mudar o retorno dessas funçoes para List<List<String>>
    suspend fun recuperaConferencias(): List<List<String>>
    suspend fun recuperaPeriodicos(): PeriodicosAdapter
    suspend fun recuperaCorrelacoes(): CorrelacoesAdapter
}

class QualisRepositoryImpl @Inject constructor(
    private val appService: QualisAppService,
    private val qualisDatabase: QualisDatabase
) : QualisRepository {

    override suspend fun getConferencias(): ConferenciasData {
        return appService.getConferencias()
    }

    override suspend fun getPeriodicos(): PeriodicosData {
        return appService.getPeriodicos()
    }

    override suspend fun getCorrelacoes(): CorrelacoesData {
        return appService.getCorrelacoes()
    }

    override suspend fun salvaConferencias(conferencias: ConferenciasData) {
        val confs = conferencias.conferencias.map {
            ConferenciaEntity(
                sigla = it[0],
                nome = it[1],
                extratoCapes = it[2]
            )
        }
        for (conf in confs){
            qualisDatabase.qualisDao().insertConferencia(conf)
        }
    }

    override suspend fun salvaCorrelacoes(correlacoes: CorrelacoesData) {
        val correlacoesEntities = correlacoes.correlacoes.map {
            CorrelacoesEntity(
                issn = it[0],
                correlacao = it[1]
            )
        }
        for (correlacaoEntity in correlacoesEntities){
            qualisDatabase.qualisDao().insertCorrelacaoComOutraArea(correlacaoEntity)
        }
    }

    override suspend fun salvaPeriodicos(periodico: PeriodicosData) {
        val periodicoEntities = periodico.periodico.map {
            PeriodicoEntity(
                issn = it[0],
                nome = it[1],
                extratoCapes = it[2]
            )
        }
        for (periodicoEntity in periodicoEntities){
            qualisDatabase.qualisDao().insertPeriodico(periodicoEntity)
        }
    }

    override suspend fun atualizarTudo() {
       val conferencias = getConferencias()
        salvaConferencias(conferencias)

       val periodicos = getPeriodicos()
       salvaPeriodicos(periodicos)

       val correlacoes = getCorrelacoes()
       salvaCorrelacoes(correlacoes)
    }

    override suspend fun recuperaConferencias(): List<List<String>> {
        val conferencias = qualisDatabase.qualisDao().selectAllConferencias()
        val conferenciaList = conferencias.map {
            listOf(
                it.sigla,
                it.nome,
                it.extratoCapes
            )
        }
       return conferenciaList
    }

    override suspend fun recuperaPeriodicos(): PeriodicosAdapter {
        val periodicos = qualisDatabase.qualisDao().selectAllPeriodicos()
        val periodicoList = periodicos.map {
            listOf(
                it.issn,
                it.nome,
                it.extratoCapes
            )
        }
        return PeriodicosAdapter(periodicoList)
    }

    override suspend fun recuperaCorrelacoes(): CorrelacoesAdapter {
        val correlacoes = qualisDatabase.qualisDao().selectAllCorrelacoes()
        val correlacoesList = correlacoes.map {
            listOf(
                it.issn,
                it.correlacao
            )
        }
        return CorrelacoesAdapter(correlacoesList)
    }
}

