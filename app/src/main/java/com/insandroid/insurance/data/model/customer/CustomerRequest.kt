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

//사고처리접수
data class PostIncident(
    val incidentDate : String,
    val carNumber : String,
    val incidentSite : String,
    val incidentPhoneNumber : String,
    val incidentCategory : String,
)

//로그인 Request
data class PostLogin(
    val email : String,
    val password : String
)

data class LineUpConsultRequest(
    val kindOfInsurance : String
)

/*

 */
/*
  "incidentDate": "string",
  "carNumber": "string",
  "incidentSite": "string",
  "incidentPhoneNumber": "string",
  "incidentCategory": "string"
 */



