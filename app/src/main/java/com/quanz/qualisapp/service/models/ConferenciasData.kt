package com.quanz.qualisapp.service.models

import com.google.gson.annotations.SerializedName

data class ConferenciasData(
    @SerializedName("data")
    val conferencias: List<List<String>>
)