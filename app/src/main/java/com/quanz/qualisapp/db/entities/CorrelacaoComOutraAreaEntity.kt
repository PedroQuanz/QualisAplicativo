package com.quanz.qualisapp.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "correlacaoComOutraArea")
data class CorrelacaoComOutraAreaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val issn: String,
    val periodico: String,
    val extratoCapesComp: String,
    val extratoCapes: String,
    val area: String
)
