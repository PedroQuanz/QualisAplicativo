package com.quanz.qualisapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quanz.qualisapp.db.dao.QualisDao
import com.quanz.qualisapp.db.entities.ConferenciaEntity
import com.quanz.qualisapp.db.entities.CorrelacaoComOutraAreaEntity
import com.quanz.qualisapp.db.entities.PeriodicoEntity

/*
Database é onde se prove acesso a database
 */
@Database(
    entities = [PeriodicoEntity::class,
        ConferenciaEntity::class,
        CorrelacaoComOutraAreaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class QualisDatabase : RoomDatabase() {
    abstract fun qualisDao(): QualisDao
}