package com.quanz.qualisapp.service.models

import com.google.gson.annotations.SerializedName

data class PeriodicosData(
    @SerializedName("data")
    val periodico: List<List<String>>
)