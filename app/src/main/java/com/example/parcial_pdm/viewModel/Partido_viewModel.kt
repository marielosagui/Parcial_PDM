package com.example.parcial_pdm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_pdm.entities.partido
import com.example.parcial_pdm.RoomDatabase_partido
import com.example.parcial_pdm.repository.repositoryPartido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Partido_viewModel(application: Application) : AndroidViewModel(application) {
    private val repository : repositoryPartido
    val allPartido : LiveData<List<partido>>
    var puntuacionA : Int = 0
    var puntuacionB : Int = 0

    init {
        val partidoDao = RoomDatabase_partido.getDatabase(application).partidoDa()
        repository = repositoryPartido(partidoDao)

        allPartido = partidoDao.getAll()
    }

    fun insert(partido : partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)
    }
}