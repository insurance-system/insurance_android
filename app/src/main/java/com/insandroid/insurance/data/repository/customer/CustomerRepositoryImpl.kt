package com.insandroid.insurance.data.repository.customer

import com.insandroid.insurance.data.api.RetrofitInstance.customerApi
import com.insandroid.insurance.data.model.customer.*
import retrofit2.Call
import retrofit2.Response

class CustomerRepositoryImpl : CustomerRepository {
    override fun customerJoin(
        joinDataRequest: JoinDataRequest
    ): Call<JoinDataResponse> {
        return customerApi.customerJoin(joinDataRequest)
    }

    override suspend fun getMyInsurance(userid: Long): Response<MyInsurance> {
        return customerApi.getMyInsurance(userid)
    }

    override suspend fun postInsurance(
        postInsurance: PostInsurance,
        userid: Long
    ): Response<PostInsuranceResponse> {
        return customerApi.postInsurance(postInsurance, userid)
    }

    override suspend fun getInsurance(
        userid: Long,
        kind_of_insurance: String
    ): Response<MyInsurance> {
        return customerApi.getInsurance(userid, kind_of_insurance)
    }

    override suspend fun postMoneyInsurance(
        userid: Long,
        postMoney: PostMoney
    ): Response<PostMoneyResponse> {
        return customerApi.postMoneyInsurance(postMoney, userid)
    }

    override suspend fun postIncident(
        userid: Long,
        postIncident: PostIncident
    ): Response<PostMoneyResponse> {
        return customerApi.postIncident(postIncident, userid)
    }

    override fun postLogin(postLogin: PostLogin): Call<PostLoginResponse> {
        return customerApi.postCustomer(postLogin)
    }

    override fun postEmployeeLogin(postLogin: PostLogin): Call<PostLoginResponse> {
        return customerApi.postEmployee(postLogin)
    }

    override suspend fun getPayment(userid: Long): Response<GetPayment> {
        return customerApi.getPayment(userid)
    }

}