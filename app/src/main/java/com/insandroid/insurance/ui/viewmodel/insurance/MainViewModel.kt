package com.insandroid.insurance.ui.viewmodel.insurance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.data.repository.insurance.InsuranceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//보험 관련 ViewModel
class MainViewModel(
    private val insuranceRepository: InsuranceRepository
) : ViewModel() {

    private val _resultWrite = MutableLiveData<WriteDataResponse>()
    val resultWrite : LiveData<WriteDataResponse>
        get() = _resultWrite

    //보험 설계 작성 POST API
    fun insuranceWrite(userid: Long, writeDataRequest: WriteDataRequest) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.insuranceWrite(userid, writeDataRequest)

        if(response.code() == 200){
            _resultWrite.postValue(response.body())
        }
    }

    private val _getLecture = MutableLiveData<InsuranceGetLecture>()
    val getLecture : LiveData<InsuranceGetLecture>
        get() = _getLecture

    //영업 교육 출력 GET API
    fun getLecture(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getLecture(userid)

        if(response.isSuccessful){
            _getLecture.postValue(response.body())
        }
    }

    private val _postLecture = MutableLiveData<WriteDataResponse>()
    val postLecture : LiveData<WriteDataResponse>
        get() = _postLecture

    //영업 교육 업로드 POST API
    fun postLecture(userid : Long, insurancePostLecture: InsurancePostLecture) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.postLecture(userid, insurancePostLecture)

        if(response.isSuccessful){
            _postLecture.postValue(response.body())
        }
    }

    private val _getInsuranceTest = MutableLiveData<InsuranceGetTest>()
    val getInsuranceTest : LiveData<InsuranceGetTest>
        get() = _getInsuranceTest

    //인수 심사 리스트 출력 API
    fun getInsuranceTest(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getInsuranceTest(userid)

        if(response.isSuccessful){
            _getInsuranceTest.postValue(response.body())
        }
    }

    private val _getInsMoneyTest = MutableLiveData<InsuranceMoneyTest>()
    val getInsMoneyTest : LiveData<InsuranceMoneyTest>
        get() = _getInsMoneyTest

    //보상금 심사 리스트 출력
    fun getMoneyTest(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getMoneyTest(userid)

        if(response.isSuccessful){
            _getInsMoneyTest.postValue(response.body())
        }
    }


}