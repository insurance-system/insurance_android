package com.insandroid.insurance.data.repository.customer

import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import retrofit2.Call
import retrofit2.Response

interface CustomerRepository {

    //회원가입 POST API
    fun customerJoin(
        joinDataRequest: JoinDataRequest
    ) : Call<JoinDataResponse>
}