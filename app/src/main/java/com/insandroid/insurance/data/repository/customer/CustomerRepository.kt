package com.insandroid.insurance.data.repository.customer

import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import retrofit2.Response

interface CustomerRepository {

    //보험 설계 작성 POST API
    suspend fun customerJoin(
        joinDataRequest: JoinDataRequest
    ) : Response<JoinDataResponse>
}