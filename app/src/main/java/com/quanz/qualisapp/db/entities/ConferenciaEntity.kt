package com.quanz.qualisapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conferencia")
data class ConferenciaEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "siglas")
    val siglas: String,

    @ColumnInfo(name = "nome")
    val nome: String,

    @ColumnInfo(name = "extratoCapes")
    val extratoCapes: String
)
