package com.kmlinn.uitest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car (
    val model: String,
    val name: String,
    val seatNo: String,
    val rentalFee: String,
    val mileageFee: String,
    val distance: String
) : Parcelable