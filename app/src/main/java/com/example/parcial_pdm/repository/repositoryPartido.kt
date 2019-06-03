package com.example.parcial_pdm.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.parcial_pdm.dao.partidoDao
import com.example.parcial_pdm.entities.partido

class repositoryPartido(private val partidoDao : partidoDao) {

    fun getAll() : LiveData<List<partido>> = partidoDao.getAll()

    @WorkerThread
    suspend fun insert(partido : partido) = partidoDao.insert(partido)

}