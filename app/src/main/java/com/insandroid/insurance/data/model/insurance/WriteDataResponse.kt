package com.insandroid.insurance.data.model.insurance

data class WriteDataResponse(
    val code : Int,

    val status : String,
    val statusCode : Int,

    val data : Result
){
    data class Result(
        val insuranceId : Int,
        val insuranceName : String,
        val fee : Int,
        val maxAge : Int,
        val minAge : Int,
        val smoke : String,
        val alcohol : String,
        val cancer : String,
        val kindOfInsurance : String
    )
}


/*
{
  "data": {
    "insuranceId": 0,
    "insuranceName": "string",
    "fee": 0,
    "maxAge": 0,
    "minAge": 0,
    "smoke": "string",
    "alcohol": "string",
    "cancer": "string",
    "kindOfInsurance": "string"
  },
  "transaction_time": "2022-11-19T11:17:54.209Z",
  "status": "100 CONTINUE",
  "description": "string",
  "statusCode": 0
}
 */
