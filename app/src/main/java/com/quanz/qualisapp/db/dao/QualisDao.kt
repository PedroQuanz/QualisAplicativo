package com.quanz.qualisapp.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.quanz.qualisapp.db.entities.ConferenciaEntity
import com.quanz.qualisapp.db.entities.CorrelacoesEntity
import com.quanz.qualisapp.db.entities.PeriodicoEntity

/*
Data access object(dao) é onde se cria o CRUD padrao e querys a serem executadas pelo app
 */
@Dao
interface QualisDao {

    ///////////////////

    @Query("SELECT * FROM periodico")
    suspend fun selectAllPeriodicos():List<PeriodicoEntity>

    @Insert(onConflict = REPLACE, entity = PeriodicoEntity::class)
    suspend fun insertPeriodico(vararg periodicoEntity: PeriodicoEntity)

    @Delete
    suspend fun deletePeriodico(periodicoEntity: PeriodicoEntity)

    ///////////////////

    @Query("SELECT * FROM conferencia")
    suspend fun selectAllConferencias():List<ConferenciaEntity>

    @Insert(onConflict = REPLACE, entity = ConferenciaEntity::class)
    suspend fun insertConferencia(vararg conferencia: ConferenciaEntity)

    @Delete
    suspend fun deleteConferencia(conferenciaEntity: ConferenciaEntity)

    ///////////////////

    @Query("SELECT * FROM CorrelacaoComOutraArea")
    suspend fun selectAllCorrelacoes() : List<CorrelacoesEntity>

    @Insert(onConflict = REPLACE, entity = CorrelacoesEntity::class)
    suspend fun insertCorrelacaoComOutraArea(vararg correlacaoComOutraArea: CorrelacoesEntity)

    @Delete
    suspend fun deleteCorrelacao(correlacoes: CorrelacoesEntity)
}