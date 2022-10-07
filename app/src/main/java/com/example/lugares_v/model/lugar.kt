package com.example.lugares_v.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "lugar")
data class lugar(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Nombre")
    val nombre: String,
    @ColumnInfo(name = "Nombre")
    val correo: String?,
    @ColumnInfo(name = "Nombre")
    val telefono: String?,
    @ColumnInfo(name = "Nombre")
    val web: String?,
    @ColumnInfo(name = "Nombre")
    val latitud: Double?,
    @ColumnInfo(name = "Nombre")
    val longitud: Double?,
    @ColumnInfo(name = "Nombre")
    val altura: Double?,
    @ColumnInfo(name = "ruta_audio")
    val rutaAudio: String?,
    @ColumnInfo(name = "ruta_imagen")
    val rutaImagen: String?
//el ? es para decir que va a hacer nulo, y esta clase es la creacion de la BD
): Parcelable
