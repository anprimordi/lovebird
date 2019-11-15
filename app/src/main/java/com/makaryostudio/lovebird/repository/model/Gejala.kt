package com.makaryostudio.lovebird.repository.model

import android.os.Parcel
import android.os.Parcelable

data class Gejala(
    var kodeGejala: Int,
    var gejalaDialami: Int,
    var bobot: Int
) : Parcelable {
    var isChecked: Boolean = false

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
        isChecked = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(kodeGejala)
        parcel.writeInt(gejalaDialami)
        parcel.writeInt(bobot)
        parcel.writeByte(if (isChecked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Gejala> {
        override fun createFromParcel(parcel: Parcel): Gejala {
            return Gejala(parcel)
        }

        override fun newArray(size: Int): Array<Gejala?> {
            return arrayOfNulls(size)
        }
    }

}