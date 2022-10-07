package com.example.lugares_v.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lugares_v.model.lugar

@Database(entities = [lugar::class], version = 1 , exportSchema = false)
abstract class LugarDataBase: RoomDatabase(){

    abstract fun lugarDao(): LugarDao

    companion object{
        @Volatile
        private var INSTANCE: LugarDataBase? = null

        fun getDataBase(context: Context): LugarDataBase{
            var local = INSTANCE
            if (local != null){
                return local
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LugarDataBase::class.java,
                    "lugar_database"
                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }
}