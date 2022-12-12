package com.quanz.qualisapp.service

import com.quanz.qualisapp.service.models.ConferenciasData
import com.quanz.qualisapp.service.models.CorrelacoesData
import com.quanz.qualisapp.service.models.PeriodicosData
import retrofit2.http.GET


interface QualisAppService {
    @GET("periodico.json")
    suspend fun getPeriodicos(): PeriodicosData

    @GET("todos2.json")
    suspend fun getCorrelacoes(): CorrelacoesData

    @GET("qualis_conferencias_2016.json")
    suspend fun getConferencias(): ConferenciasData
}