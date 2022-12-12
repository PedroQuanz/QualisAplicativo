package com.quanz.qualisapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quanz.qualisapp.db.dao.QualisDao
import com.quanz.qualisapp.db.entities.Correlacoes
import com.quanz.qualisapp.db.entities.ConferenciaEntity as Conferencias
import com.quanz.qualisapp.db.entities.PeriodicoEntity as Periodicos


@Database(
    entities = [Periodicos::class, Conferencias::class, Correlacoes::class],
    version = 1,
    exportSchema = false
)
abstract class QualisDatabase : RoomDatabase() {
    abstract fun qualisDao(): QualisDao
}