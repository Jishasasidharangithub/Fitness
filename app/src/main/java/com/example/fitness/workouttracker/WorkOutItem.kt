package com.example.fitness.workouttracker

import android.os.Parcel
import android.os.Parcelable

data class WorkoutItem(
    val title:String,
    val description:String,
    val button:String,
    val image:Int

) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(button)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkoutItem> {
        override fun createFromParcel(parcel: Parcel): WorkoutItem {
            return WorkoutItem(parcel)
        }

        override fun newArray(size: Int): Array<WorkoutItem?> {
            return arrayOfNulls(size)
        }
    }
}

