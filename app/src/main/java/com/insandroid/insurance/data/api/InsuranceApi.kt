package com.insandroid.insurance.data.api

import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//보험 관련 API
interface InsuranceApi {

    //보험 설계 POST API
    @POST("/insurance/")
    suspend fun insuranceWrite(
        @Body body : WriteDataRequest
    ) : Response<WriteDataResponse>

    //영업 교육 강의 리스트 출력
    @GET("/insurance-employee/education")
    suspend fun getLecture() : Response<InsuranceGetLecture>

}