package com.insandroid.insurance.data.model.customer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//보험 가입 신청하기
data class PostInsurance(
    val insuranceId : Int
)

//보험금 청구 가입 신청하기
data class PostMoney(
    val insuranceId : Int,
    val claimContent : String,
    val claimCost : Int
)
