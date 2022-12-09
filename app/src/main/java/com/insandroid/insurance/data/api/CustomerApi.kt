package com.insandroid.insurance.data.api

import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

//보험 관련 API
interface CustomerApi {

    //보험 설계 POST API
    @POST("/customer/join")
    fun customerJoin(
        @Body body : JoinDataRequest
    ) : Call<JoinDataResponse>

}