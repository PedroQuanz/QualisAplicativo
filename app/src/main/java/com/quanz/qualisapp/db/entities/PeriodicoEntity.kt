package com.quanz.qualisapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Cada tabela representa uma entidade, novas tabelas serao criadas a partir de novas entidades
conforme exemplo:
 */

@Entity(tableName = "periodico")
data class PeriodicoEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "issn")
    val issn: String,
    @ColumnInfo(name = "nome")
    val nome: String,
    @ColumnInfo(name = "extratoCapes")
    val extratoCapes: String
)
