package com.insandroid.insurance.data.repository

import com.insandroid.insurance.data.api.InsuranceApi
import com.insandroid.insurance.data.api.RetrofitInstance.api
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import retrofit2.Response

class InsuranceRepositoryImpl : InsuranceRepository{

    //보험 설계 작성 POST API
    override suspend fun insuranceWrite(
        writeDataRequest: WriteDataRequest
    ): Response<WriteDataResponse> {
        return api.insuranceWrite(writeDataRequest)
    }
}