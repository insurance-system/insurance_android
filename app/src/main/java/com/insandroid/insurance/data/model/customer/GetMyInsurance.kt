package com.insandroid.insurance.data.model.customer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetMyInsurance(
    val insuranceId : Int,
    val insuranceName : String,
    val minAge : Int,
    val fee : Int,
    val maxAge : Int,
    val alcohol : String,
    val smoke : String,
    val cancer : String,
    val kindOfInsurance : String,
) : Parcelable

