package com.quanz.qualisapp.repository

import android.content.Context
import androidx.room.Room
import com.quanz.qualisapp.db.QualisDatabase
import com.quanz.qualisapp.db.entities.ConferenciaEntity
import com.quanz.qualisapp.service.QualisAppService
import com.quanz.qualisapp.ui.MainActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


interface QualisRepository {
    suspend fun getConferencias(): List<List<String>>
    suspend fun getPeriodicos(): List<List<String>>
    suspend fun getCorrelacoes(): List<List<String>>
    suspend fun atualizarTudo()
    suspend fun saveConferencias(conferenciaEntity: ConferenciaEntity)
}

class QualisRepositoryImpl @Inject constructor(
    private val appService: QualisAppService,
    private val qualisDatabase: QualisDatabase
) : QualisRepository {

    // TODO: Implementar todos os endpoints
    // TODO: Criar metodo para salvar os dados

    enum class FonteDeDados {
        CONFERENCIAS,
        PERIODICO,
        CORRELACOES
    }

    companion object {
        const val BASE_URL = "https://qualis.ic.ufmt.br/"
    }

    override suspend fun getConferencias(): List<List<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPeriodicos(): List<List<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCorrelacoes(): List<List<String>> {
        return appService.getCorrelacoes().correlacoes
    }

    override suspend fun atualizarTudo() {
        TODO("Not yet implemented")
    }

    override suspend fun saveConferencias(conferenciaEntity: ConferenciaEntity) {
        qualisDatabase.qualisDao().insertConferencia(conferenciaEntity)
    }
}

