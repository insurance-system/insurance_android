package com.insandroid.insurance.data.repository.customer

import com.insandroid.insurance.data.api.RetrofitInstance.customerApi
import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import retrofit2.Response

class CustomerRepositoryImpl : CustomerRepository {
    override suspend fun customerJoin(
        joinDataRequest: JoinDataRequest
    ): Response<JoinDataResponse> {
        return customerApi.customerJoin(joinDataRequest)
    }

}