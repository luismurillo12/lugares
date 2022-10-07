package com.example.lugares_v.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lugares_v.model.lugar

@Dao
interface LugarDao {
    //Las funcionaes de bajo nivel para hacer un CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)//que si no lo puede insertar que no de error
    suspend fun addLugar(lugar: lugar)//esto va a insertar un registro en mi tabla

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upadateLugar(lugar: lugar)//esto va a actualizar un registro en mi tabla

    @Delete
    suspend fun deleteLugar(lugar: lugar)//esto va a eliminar un registro en mi tabla

    @Query("SELECT * FROM LUGAR")//Consulta general de SQL
    fun getLugares() : LiveData<List<lugar>> //datos que se pueden cargar en tiempo real
}
