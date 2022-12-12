package com.quanz.qualisapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "correlacaoComOutraArea")
data class Correlacoes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "issn")
    val issn: String,
    @ColumnInfo(name = "periodico")
    val periodico: String,
    @ColumnInfo(name = "extratoCapesComp")
    val extratoCapesComp: String,
    @ColumnInfo(name = "extratoCapes")
    val extratoCapes: String,
    @ColumnInfo(name = "area")
    val area: String
)
