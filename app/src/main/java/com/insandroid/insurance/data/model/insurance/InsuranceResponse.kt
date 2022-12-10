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
