package com.insandroid.insurance.data.model.customer

//회원가입 Request Data Response
data class JoinDataResponse(
    val httpCode : Int,
    val errorCode : String,
    val localDateTime : String,
    val httpStatus : String,
    val message : String,
    val success : Boolean,

    val statusCode : Int
)


/*
실패
{
  "httpCode": 400,
  "errorCode": "C1000",
  "localDateTime": "2022-12-07T15:46:00.390218",
  "httpStatus": "BAD_REQUEST",
  "message": "잘못된 이메일 형식입니다. 형식(mju@naver.com)",
  "success": false
}
 */

/*
성공
  "data": null,
  "transaction_time": "2022-12-07T15:47:21.987987",
  "status": "OK",
  "description": null,
  "statusCode": 0
 */