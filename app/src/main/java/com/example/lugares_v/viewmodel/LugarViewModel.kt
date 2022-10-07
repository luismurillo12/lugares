package com.example.lugares_v.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.lugares_v.data.LugarDao
import com.example.lugares_v.data.LugarDataBase
import com.example.lugares_v.model.lugar
import com.example.lugares_v.repository.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugarViewModel(application: Application) : AndroidViewModel(application) {
    private val lugarRepository: LugarRepository = TODO()
    val getLugares: LiveData<List<lugar>>

    init {
        val lugarDao= LugarDataBase.getDataBase(application).lugarDao()
        lugarRepository= LugarRepository(lugarDao)
        getLugares= lugarRepository.getLugares
    }

    fun saveLugar(lugar:lugar){
        viewModelScope.launch(Dispatchers.IO){
            lugarRepository.saveLugar(lugar)
        }

        fun deleteLugar(lugar:lugar){
            viewModelScope.launch(Dispatchers.IO){
                lugarRepository.deleteLugar(lugar)
            }
        }

    }


}