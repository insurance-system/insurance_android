package com.insandroid.insurance.data.api

import com.insandroid.insurance.data.model.insurance.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

//보험 관련 API
interface InsuranceApi {

    //보험 설계 POST API
    @POST("/insurance-employee/development")
    suspend fun insuranceWrite(
        @Header("userid") userid: Long,
        @Body body : WriteDataRequest
    ) : Response<WriteDataResponse>

    //영업 교육 강의 리스트 출력
    @GET("/insurance-employee/education")
    suspend fun getLecture(
        @Header("userid") userid: Long,
    ) : Response<InsuranceGetLecture>

    //보험 설계 POST API
    @POST("/insurance-employee/education")
    suspend fun postLecture(
        @Header("userid") userid: Long,
        @Body body : InsurancePostLecture
    ) : Response<WriteDataResponse> //Response 가 필요없을 것 같음

    //인수심사 리스트 출력 GET API
    @GET("/insurance-employee/uw")
    suspend fun getInsuranceTest(
        @Header("userid") userid: Long
    ) : Response<InsuranceGetTest>

    //보상금 심사 리스트 출력 GET API
    @GET("/insurance-employee/reward")
    suspend fun getInsMoneyTest(
        @Header("userid") userid: Long
    ) : Response<InsuranceMoneyTest>

}