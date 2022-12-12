package com.insandroid.insurance.data.repository.insurance

import com.insandroid.insurance.data.model.customer.PostInsuranceResponse
import com.insandroid.insurance.data.model.insurance.*
import retrofit2.Response
import retrofit2.http.Header

//보험 관련 Repository
interface InsuranceRepository {

    //보험 설계 작성 POST API
    suspend fun insuranceWrite(
        userid: Long,
        writeDataRequest: WriteDataRequest
    ) : Response<WriteDataResponse>

    //영업 교육 조회
    suspend fun getLecture(
        userid: Long,
    ) : Response<InsuranceGetLecture>

    //영업 교육 등록
    suspend fun postLecture(
        userid : Long,
        insurancePostLecture: InsurancePostLecture
    ) : Response<WriteDataResponse>

    //인수 심사 리스트 출력
    suspend fun getInsuranceTest(
        userid: Long
    ) : Response<InsuranceGetTest>

    //인수 심사 수행
    suspend fun patchInsuranceTest(
        userid: Long,
        patchInsTest: PatchInsTest
    ) : Response<InsuranceGetTest>

    //보상금 심사 리스트 출력
    suspend fun getMoneyTest(
        userid: Long
    ) : Response<InsuranceMoneyTest>

    //보상금 심사 수행
    suspend fun patchMoneyTest(
        userid: Long,
        patchMoneyTest: PatchMoneyTest
    ) : Response<InsuranceGetTest>

    //상담 대기 신규 고객 리스트 출력
    suspend fun getInsCustomer(
        userid: Long
    ) : Response<InsuranceGetCustomer>

    //사고 접수 리스트 출력
    suspend fun getIncidentInfor(
        userid: Long
    ) : Response<IncidentGet>

    //사고 접수 담당자 배정
    suspend fun patchIncidentInfor(
        userid: Long,
        incident_log_id : Int,
    ) : Response<IncidentGet>

    //상담사 배정
    suspend fun postSalesInterest(
        userid: Long,
        empCusId : Long,
    ): Response<PostInsuranceResponse>

    //미납고객조회
    suspend fun getNonPayment(
        userid: Long,
    ) : Response<GetNonPayment>

    //만기고객조회
    suspend fun getLastInsurance(
        userid: Long,
    ) : Response<GetNonPayment>
}