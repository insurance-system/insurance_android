package com.insandroid.insurance.data.api

import com.insandroid.insurance.data.model.customer.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

//보험 관련 API
interface CustomerApi {

    //회원가입 POST API
    @POST("/customer/join")
    fun customerJoin(
        @Body body : JoinDataRequest
    ) : Call<JoinDataResponse>

    //고객 로그인 POST API
    @POST("/customer/login")
    fun postCustomer(
        @Body body : PostLogin
    ) : Call<PostLoginResponse>

    //관리자 로그인 POST API
    @POST("/employee/login")
    fun postEmployee(
        @Body body : PostLogin
    ) : Call<PostLoginResponse>

    //가입된 보험 정보 리스트 GET API
    @GET("/insurance-customer/insurance")
    suspend fun getMyInsurance(
        @Header("userid") userid: Long
    ) : Response<MyInsurance>

    //보험 가입 신청 POST API
    @POST("/insurance-customer/insurance")
    suspend fun postInsurance(
        @Body body : PostInsurance,
        @Header("userid") userid: Long
    ) : Response<PostInsuranceResponse>

    //고객이 보험 목록 조회 GET API , LIFE, NON_LIFE
    @GET("/insurance-customer/insurance/{kind_of_insurance}")
    suspend fun getInsurance(
        @Header("userid") userid: Long,
        @Path("kind_of_insurance") kind_of_insurance : String
    ) : Response<MyInsurance>

    //보험금 청구하기 POST API
    @POST("/insurance-customer/insurance-claim")
    suspend fun postMoneyInsurance(
        @Body body : PostMoney,
        @Header("userid") userid: Long
    ) : Response<PostMoneyResponse>

    //사고처리 접수 POST API
    @POST("/insurance-customer/incident-accept")
    suspend fun postIncident(
        @Body body : PostIncident,
        @Header("userid") userid: Long
    ) : Response<PostMoneyResponse>

    //보험금 납부내역
    @GET("/insurance-customer/payment-history")
    suspend fun getPayment(
        @Header("userid") userid: Long
    ) : Response<GetPayment>

    //상담대기요청
    @POST("/insurance-customer/consults")
    suspend fun postConsults(
        @Body body : LineUpConsultRequest,
        @Header("userid") userid: Long
    ) : Response<PostLoginResponse>

}