package com.insandroid.insurance.data.repository.insurance

import com.insandroid.insurance.data.api.RetrofitInstance.insuranceApi
import com.insandroid.insurance.data.model.insurance.*
import retrofit2.Response
import retrofit2.http.Header

class InsuranceRepositoryImpl : InsuranceRepository {

    //보험 설계 작성 POST API
    override suspend fun insuranceWrite(
        userid: Long,
        writeDataRequest: WriteDataRequest
    ): Response<WriteDataResponse> {
        return insuranceApi.insuranceWrite(userid, writeDataRequest)
    }

    override suspend fun getLecture(
        userid : Long,
    ): Response<InsuranceGetLecture> {
        return insuranceApi.getLecture(userid)
    }

    override suspend fun postLecture(
        userid : Long,
        insurancePostLecture: InsurancePostLecture
    ): Response<WriteDataResponse> {
        return insuranceApi.postLecture(userid, insurancePostLecture)
    }

    override suspend fun getInsuranceTest(userid: Long): Response<InsuranceGetTest> {
        return insuranceApi.getInsuranceTest(userid)
    }

    override suspend fun getMoneyTest(userid: Long): Response<InsuranceMoneyTest> {
        return insuranceApi.getInsMoneyTest(userid)
    }
}