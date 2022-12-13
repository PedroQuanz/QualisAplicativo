package com.quanz.qualisapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "correlacaoComOutraArea")
data class CorrelacoesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "issn")
    val issn: String,
    @ColumnInfo(name = "correlacao")
    val correlacao: String,
    @ColumnInfo(name = "extratoCapesComp")
    val extratoCapesComp: String? = null,
    @ColumnInfo(name = "extratoCapes")
    val extratoCapes: String? = null,
    @ColumnInfo(name = "area")
    val area: String? = null
)
