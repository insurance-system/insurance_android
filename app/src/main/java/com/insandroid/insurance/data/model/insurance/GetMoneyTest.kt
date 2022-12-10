package com.insandroid.insurance.data.model.insurance

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//보상금심사 Response
//Parcelable 로 넘기기 위해 따로 뺴놓음
@Parcelize
data class GetMoneyTest(
    val insuranceClaimId : Int,
    val claimContent : String,
    val customerName : String,
    val insuranceName : String,
    val kindOfInsurance : String,
    val claimCost : Int,
): Parcelable
