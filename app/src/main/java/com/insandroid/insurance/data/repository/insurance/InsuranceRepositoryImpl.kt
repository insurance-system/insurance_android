package com.insandroid.insurance.data.repository.insurance

import com.insandroid.insurance.data.api.RetrofitInstance.insuranceApi
import com.insandroid.insurance.data.model.customer.PostInsuranceResponse
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

    override suspend fun patchInsuranceTest(
        userid: Long,
        patchInsTest: PatchInsTest
    ): Response<InsuranceGetTest> {
        return insuranceApi.patchInsuranceTest(userid, patchInsTest)
    }

    override suspend fun getMoneyTest(userid: Long): Response<InsuranceMoneyTest> {
        return insuranceApi.getInsMoneyTest(userid)
    }

    override suspend fun patchMoneyTest(
        userid: Long,
        patchMoneyTest: PatchMoneyTest
    ): Response<InsuranceGetTest> {
        return insuranceApi.patchMoneyTest(userid, patchMoneyTest)
    }

    override suspend fun getInsCustomer(userid: Long): Response<InsuranceGetCustomer> {
        return insuranceApi.getInsCustomer(userid)
    }

    override suspend fun getIncidentInfor(userid: Long): Response<IncidentGet> {
        return insuranceApi.getIncident(userid)
    }

    override suspend fun patchIncidentInfor(
        userid: Long,
        incident_log_id: Int
    ): Response<IncidentGet> {
        return insuranceApi.patchIncident(userid, incident_log_id)
    }

    override suspend fun postSalesInterest(
        userid: Long,
        empCusId: Long
    ): Response<PostInsuranceResponse> {
        return insuranceApi.postSalesInterest(userid, empCusId)
    }

    override suspend fun getNonPayment(userid: Long): Response<GetNonPayment> {
        return insuranceApi.getNonPayment(userid)
    }

    override suspend fun getLastInsurance(userid: Long): Response<GetNonPayment> {
        return insuranceApi.getLastInsurance(userid)
    }

    override suspend fun getInsStateA(userid: Long): Response<GetNonPayment> {
        return insuranceApi.getInsStateA(userid)
    }

    override suspend fun getInsStateB(userid: Long): Response<GetNonPayment> {
        return insuranceApi.getInsStateB(userid)
    }
}