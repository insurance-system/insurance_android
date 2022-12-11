package com.insandroid.insurance.data.model.insurance

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//사고 접수 Response
//Parcelable 로 넘기기 위해 따로 뺴놓음
@Parcelize
data class GetIncidentInfor(
    val incidentLogId : Int,
    val customerName : String,
    val incidentPhoneNumber : String,
    val incidentDate : String,
    val incidentSite : String,
    val incidentCategory : String,
): Parcelable

