package com.insandroid.insurance.data.model.insurance

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//영업 강의 출력 리스트 Response
data class InsuranceGetLecture(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetLectureResult>
){
    data class GetLectureResult(
        val lectureName : String,
        val lectureUrl : String,
    )
}

//인수 심사 리스트 Response
data class InsuranceGetTest(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetInsuranceTest>
)

//보상금 심사 리스트 Response
data class InsuranceMoneyTest(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetMoneyTest>
)

//상담 대기 신규고객 명단 리스트 Response
data class InsuranceGetCustomer(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetInsCustomer>

)

//사고 접수 리스트 Response
data class IncidentGet(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetIncidentInfor>

)

//미납 고객 조히ㅗ
data class GetNonPayment(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,
//
    val data : List<NonPayment>
){
    data class NonPayment(
        val customerName : String,
        val phoneNum : String,
        val kindOfJob : String,
        val insuranceName : String,
        val fee : Int,
        val kindOfInsurance : String,
    )
}