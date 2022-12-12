package com.quanz.qualisapp.repository

import android.content.Context
import androidx.room.Room
import com.quanz.qualisapp.db.QualisDatabase
import com.quanz.qualisapp.service.QualisAppService
import com.quanz.qualisapp.ui.MainActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


interface QualisRepository {
    fun getConferencias(): List<List<String>>
    fun getPeriodicos(): List<List<String>>
    fun getCorrelacoes(): List<List<String>>
}

class QualisRepositoryImpl @Inject constructor(
    appService: QualisAppService
) : QualisRepository {

    enum class FonteDeDados {
        CONFERENCIAS,
        PERIODICO,
        CORRELACOES
    }

    companion object {
        const val BASE_URL = "https://qualis.ic.ufmt.br/"
    }

    override fun getConferencias(): List<List<String>> {

        TODO("Not yet implemented")
    }

    override fun getPeriodicos(): List<List<String>> {
        TODO("Not yet implemented")
    }

    override fun getCorrelacoes(): List<List<String>> {
        TODO("Not yet implemented")

    }

    //    private suspend fun recuperaInformacoes(fonteDeDados: FonteDeDados): List<List<String>> {
    //        return when(fonteDeDados){
    //            FonteDeDados.CONFERENCIAS -> service.getConferencias().conferencia
    //            FonteDeDados.PERIODICO -> service.getPeriodicos().periodico
    //            FonteDeDados.CORRELACOES -> service.getCorrelacoes().correlacoes
    //
    //}
}

