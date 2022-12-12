package com.insandroid.insurance.data.repository.customer

import com.insandroid.insurance.data.model.customer.*
import retrofit2.Call
import retrofit2.Response

interface CustomerRepository {

    //회원가입 POST API
    fun customerJoin(
        joinDataRequest: JoinDataRequest
    ) : Call<JoinDataResponse>

    //내 보험 출력
    suspend fun getMyInsurance(
        userid: Long
    ) : Response<MyInsurance>

    //보험 가입 신청하기
    suspend fun postInsurance(
        postInsurance: PostInsurance,
        userid: Long
    ) : Response<PostInsuranceResponse>

    //보험 정보 출력
    suspend fun getInsurance(
        userid: Long,
        kind_of_insurance : String
    ) : Response<MyInsurance>

    //보험금 청구하기
    suspend fun postMoneyInsurance(
        userid: Long,
        postMoney: PostMoney
    ) : Response<PostMoneyResponse>

    //보험금 청구하기
    suspend fun postIncident(
        userid: Long,
        postIncident: PostIncident
    ) : Response<PostMoneyResponse>

    //유저 로그인
    fun postLogin(
        postLogin: PostLogin
    ) : Call<PostLoginResponse>

    //사원 로그인
    fun postEmployeeLogin(
        postLogin: PostLogin
    ) : Call<PostLoginResponse>

    //보험금 납부내역
    suspend fun getPayment(
        userid: Long,
    ) : Response<GetPayment>

    //상담 요청하기
    suspend fun postConsults(
        lineUpConsultRequest: LineUpConsultRequest,
        userid: Long,
    ) : Response<PostLoginResponse>


}