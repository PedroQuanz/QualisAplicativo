package com.quanz.qualisapp.service.models

import com.google.gson.annotations.SerializedName

data class CorrelacaoComOutrasAreasData(
    @SerializedName("data")
    val correlacaoComOutrasAreas: List<List<String>>
)