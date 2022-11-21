package com.insandroid.insurance.data.repository

import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import retrofit2.Response

interface InsuranceRepository {

    //보험 설계 작성 POST API
    suspend fun insuranceWrite(
        writeDataRequest: WriteDataRequest
    ) : Response<WriteDataResponse>
}