package com.insandroid.insurance.data.model.customer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//가입된 보험 정보 Response
data class MyInsurance(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetMyInsurance>
)

data class PostInsuranceResponse(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : PostInsRes
){
    data class PostInsRes(
        val insuranceName : String,
        val kindOfInsurance : String,
        val contractStatus : String,
    )
}
/*
 "insuranceName": "string",
    "kindOfInsurance": "string",
    "contractStatus": "string"
 */