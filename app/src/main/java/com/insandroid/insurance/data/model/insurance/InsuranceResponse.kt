package com.insandroid.insurance.data.model.insurance

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
){
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
    )
}

//보상금 심사 리스트 Response
data class InsuranceMoneyTest(
    val status : String,
    val description : String,
    val statusCode : Int,
    val transaction_time : String,

    val data : List<GetMoneyTest>
){
    data class GetMoneyTest(
        val insuranceClaimId : Int,
        val claimContent : String,
        val customerName : String,
        val insuranceName : String,
        val kindOfInsurance : String,
        val claimCost : Int,
    )
}

/*
{
  "data": [
    {
      "insuranceClaimId": 0,
      "claimContent": "string",
      "claimCost": 0,
      "customerName": "string",
      "insuranceName": "string",
      "kindOfInsurance": "string"
    }
  ],
  "transaction_time": "2022-12-10T13:27:33.567Z",
  "status": "100 CONTINUE",
  "description": "string",
  "statusCode": 0
}
 */