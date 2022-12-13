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

//보험금 청구하기, 사고처리접수
data class PostMoneyResponse(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,
)

//로그인 Response
data class PostLoginResponse(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,
    val errorCode : String,
//
    val data : LoginResponse
){
    data class LoginResponse(
        val id : Long,
        val kindOfRole : String,
        val name : String
    )
}

//보험금 납부내역 Response
data class GetPayment(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,
//
    val data : List<PaymentHistory>
){
    data class PaymentHistory(
        val paymentId : Int,
        val payCost : Int,
        val payDate : String
    )
}

//사고처리 접수 리스트
data class GetDamageIncident(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,
//
    val data : List<DamageIncident>
){
    data class DamageIncident(
        val customerName : String,
        val phoneNum : String,

        val empName : String,
        val empPhoneNum : String
    )
}
/*
"customerName": "string",
      "phoneNum": "string",
      "address": {
        "address": "string",
        "detailAddress": "string",
        "zipcode": "string"
      },
      "empName": "string",
      "empPhoneNum": "string"
 */

/*
"paymentId": 0,
      "payCost": 0,
      "payDate": "string"

 */
/*
{
  "data": {
    "id": 23,
    "kindOfRole": "customer"
  },
  "transaction_time": "2022-12-12T15:17:27.597782",
  "status": "OK",
  "description": null,
  "statusCode": 0
}
 */
/*
 "insuranceName": "string",
    "kindOfInsurance": "string",
    "contractStatus": "string"
 */