package com.makaryostudio.lovebird.repository.model

import android.os.Parcel
import android.os.Parcelable

data class Penyakit(
    var kodePenyakit: Int,
    var namaPenyakit: String?,
    var deskripsiPenyakit: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(kodePenyakit)
        parcel.writeString(namaPenyakit)
        parcel.writeString(deskripsiPenyakit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Penyakit> {
        override fun createFromParcel(parcel: Parcel): Penyakit {
            return Penyakit(parcel)
        }

        override fun newArray(size: Int): Array<Penyakit?> {
            return arrayOfNulls(size)
        }
    }
}