package com.insandroid.insurance.data.model.insurance

//영업 강의 업로드 Request
data class InsurancePostLecture(
    val lectureName : String,
    val lectureUrl : String,
)

//인수심사 수행 Request
data class PatchInsTest(
    val contractId : Int,
    val contractStatus : String,
)

//보상금 심사 수행 Request
data class PatchMoneyTest(
    val insuranceClaimId : Int,
    val evaluateFee : Int,
)

/*
{
  "lectureName": "string",
  "lectureUrl": "string"
}
 */