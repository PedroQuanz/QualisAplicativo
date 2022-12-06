package com.quanz.qualisapp.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conferencia")
data class ConferenciaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val siglas: String,

    val nome: String,

    val extratoCapes: String
)
