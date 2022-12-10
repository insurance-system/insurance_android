package com.insandroid.insurance.data.repository.insurance

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
}