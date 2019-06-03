package com.example.parcial_pdm.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class partido (
    @ColumnInfo(name = "equipo1") val equipo1 : String,
    @ColumnInfo(name = "equipo2") val equipo2 : String,
    @ColumnInfo(name = "puntuacion1") val puntuacion1: Int,
    @ColumnInfo(name = "puntuacion2") val puntuacion2: Int,
    @ColumnInfo(name = "ganador") val ganador : String,
    @ColumnInfo(name = "fecha") val fecha : String,
    @ColumnInfo(name = "hora") val hora : String
) : Parcelable{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_partido") var id : Long = 0

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        id = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(equipo1)
        parcel.writeString(equipo2)
        parcel.writeInt(puntuacion1)
        parcel.writeInt(puntuacion2)
        parcel.writeString(ganador)
        parcel.writeString(fecha)
        parcel.writeString(hora)
        parcel.writeLong(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<partido> {
        override fun createFromParcel(parcel: Parcel): partido {
            return partido(parcel)
        }

        override fun newArray(size: Int): Array<partido?> {
            return arrayOfNulls(size)
        }
    }
}