package com.insandroid.insurance.data.api

import com.insandroid.insurance.data.model.customer.PostInsuranceResponse
import com.insandroid.insurance.data.model.insurance.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
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
    ) : Response<WriteDataResponse> //Response 안쓰임

    //인수심사 리스트 출력 GET API
    @GET("/insurance-employee/uw")
    suspend fun getInsuranceTest(
        @Header("userid") userid: Long
    ) : Response<InsuranceGetTest>

    //인수심사 하기 Patch API
    @PATCH("/insurance-employee/uw")
    suspend fun patchInsuranceTest(
        @Header("userid") userid: Long,
        @Body body : PatchInsTest
    ) : Response<InsuranceGetTest> //Response 안쓰임

    //보상금 심사 리스트 출력 GET API
    @GET("/insurance-employee/reward")
    suspend fun getInsMoneyTest(
        @Header("userid") userid: Long
    ) : Response<InsuranceMoneyTest>

    //보상금심사 하기 Patch API
    @PATCH("/insurance-employee/reward")
    suspend fun patchMoneyTest(
        @Header("userid") userid: Long,
        @Body body : PatchMoneyTest
    ) : Response<InsuranceGetTest> //Response 안쓰임

    //상담 대기 신규 고객 조회 GET API
    @GET("/insurance-employee/sales/new-customer")
    suspend fun getInsCustomer(
        @Header("userid") userid: Long
    ) : Response<InsuranceGetCustomer>

    //사고 접수 조회 GET API
    @GET("/insurance-employee/damage")
    suspend fun getIncident(
        @Header("userid") userid: Long
    ) : Response<IncidentGet>

    //사고 접수 담당자 배정 PATCH API
    @PATCH("/insurance-employee/damage/{incident_log_id}")
    suspend fun patchIncident(
        @Header("userid") userid: Long,
        @Path("incident_log_id") incident_log_id : Int
    ) : Response<IncidentGet> //Response 안쓰임

    //상담 담당자 배정 API
    @POST("/insurance-employee/sales/interest/{empCusId}")
    suspend fun postSalesInterest(
        @Header("userid") userid: Long,
        @Path("empCusId") empCusId : Long
    ) : Response<PostInsuranceResponse> //Response 안쓰임

}