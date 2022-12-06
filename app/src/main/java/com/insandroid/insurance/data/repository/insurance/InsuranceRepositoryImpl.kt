package com.insandroid.insurance.data.repository.insurance

import com.insandroid.insurance.data.api.RetrofitInstance.insuranceApi
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import retrofit2.Response

class InsuranceRepositoryImpl : InsuranceRepository {

    //보험 설계 작성 POST API
    override suspend fun insuranceWrite(
        writeDataRequest: WriteDataRequest
    ): Response<WriteDataResponse> {
        return insuranceApi.insuranceWrite(writeDataRequest)
    }

    override suspend fun getLecture(): Response<InsuranceGetLecture> {
        return insuranceApi.getLecture()
    }
}