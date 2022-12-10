package com.insandroid.insurance.data.repository.insurance

import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsurancePostLecture
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import retrofit2.Response
import retrofit2.http.Header

//보험 관련 Repository
interface InsuranceRepository {

    //보험 설계 작성 POST API
    suspend fun insuranceWrite(
        userid: Long,
        writeDataRequest: WriteDataRequest
    ) : Response<WriteDataResponse>

    suspend fun getLecture(
        userid: Long,
    ) : Response<InsuranceGetLecture>

    suspend fun postLecture(
        userid : Long,
        insurancePostLecture: InsurancePostLecture
    ) : Response<WriteDataResponse>
}