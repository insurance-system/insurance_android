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

/*
  "data": [
    {
      "lectureName": "과목1",
      "lectureUrl": "www"
    },
    {
      "lectureName": "과목2",
      "lectureUrl": "aaa"
    },
    {
      "lectureName": "과목3",
      "lectureUrl": "wwwcom"
    }
  ],
  "transaction_time": "2022-12-06T21:07:40.184782",
  "status": "OK",
  "description": null,
  "statusCode": 0
 */