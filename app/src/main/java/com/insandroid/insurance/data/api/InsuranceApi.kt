package com.insandroid.insurance.data.api

import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface InsuranceApi {

    //보험 설계 POST API
    @POST("/insurance/")
    suspend fun insuranceWrite(
        @Body body : WriteDataRequest
    ) : Response<WriteDataResponse>

}