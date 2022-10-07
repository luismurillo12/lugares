package com.example.lugares_v.repository

import androidx.lifecycle.LiveData
import com.example.lugares_v.data.LugarDao
import com.example.lugares_v.model.lugar

class LugarRepository(private val lugarDao: LugarDao) {
    suspend fun saveLugar(lugar:lugar){
        if (lugar.id==0){
            lugarDao.addLugar(lugar)//Si es un lugar nuevo se añade aca
        }else{
            lugarDao.upadateLugar(lugar)// si ya el lugar se sabe el id se actualiza aca
        }
    }
    suspend fun deleteLugar(lugar:lugar){
        if (lugar.id!=0){//Si el id tiene un valor lo va a intentar eliminar
            lugarDao.deleteLugar(lugar)
        }
    }

    val getLugares: LiveData<List<lugar>> = lugarDao.getLugares()
}