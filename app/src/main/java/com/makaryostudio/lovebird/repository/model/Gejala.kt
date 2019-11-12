package com.makaryostudio.lovebird.repository.model

import android.os.Parcel
import android.os.Parcelable

data class Gejala(
    var kodeGejala: String = "",
    var gejalaDialami: String = "",
    var bobot: Int,
    var checked: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kodeGejala)
        parcel.writeString(gejalaDialami)
        parcel.writeInt(bobot)
        parcel.writeByte(if (checked) 1 else 0)
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