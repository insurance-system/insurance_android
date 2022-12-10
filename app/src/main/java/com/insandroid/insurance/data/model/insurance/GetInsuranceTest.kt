package com.insandroid.insurance.data.model.insurance

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//인수심사 Response
//Parcelable 로 넘기기 위해 따로 뺴놓음
@Parcelize
data class GetInsuranceTest(
    val contractId : Int,
    val customerCancer : String,
    val customerSmoke : String,
    val customerAlcohol : String,
    val insuranceName : String,
    val kindOfInsurance : String,
    val insuranceFee : Int,
    val insuranceCancer : String,
    val insuranceSmoke : String,
    val insuranceAlcohol : String,
): Parcelable
