package com.example.fitness.workouttracker

import android.os.Parcel
import android.os.Parcelable

data class ExecricesItem(
    val image:Int,
    val title:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()?:"",
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExecricesItem> {
        override fun createFromParcel(parcel: Parcel): ExecricesItem {
            return ExecricesItem(parcel)
        }

        override fun newArray(size: Int): Array<ExecricesItem?> {
            return arrayOfNulls(size)
        }
    }
}
