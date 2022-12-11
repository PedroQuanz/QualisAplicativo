package com.quanz.qualisapp.service.models

import com.google.gson.annotations.SerializedName

data class CorrelacoesData(
    @SerializedName("data")
    val correlacoes: List<List<String>>
)