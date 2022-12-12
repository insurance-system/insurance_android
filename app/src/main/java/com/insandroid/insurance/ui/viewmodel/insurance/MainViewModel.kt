package com.insandroid.insurance.ui.viewmodel.insurance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.insandroid.insurance.data.model.customer.PostInsuranceResponse
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.data.repository.insurance.InsuranceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//보험 관련 ViewModel
class MainViewModel(
    private val insuranceRepository: InsuranceRepository
) : ViewModel() {

    //보험 설계 작성 POST API
    private val _resultWrite = MutableLiveData<WriteDataResponse>()
    val resultWrite : LiveData<WriteDataResponse>
        get() = _resultWrite


    fun insuranceWrite(userid: Long, writeDataRequest: WriteDataRequest) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.insuranceWrite(userid, writeDataRequest)

        if(response.code() == 200){
            _resultWrite.postValue(response.body())
        }
    }

    //영업 교육 출력 GET API
    private val _getLecture = MutableLiveData<InsuranceGetLecture>()
    val getLecture : LiveData<InsuranceGetLecture>
        get() = _getLecture

    fun getLecture(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getLecture(userid)

        if(response.isSuccessful){
            _getLecture.postValue(response.body())
        }
    }

    //영업 교육 업로드 POST API
    private val _postLecture = MutableLiveData<WriteDataResponse>()
    val postLecture : LiveData<WriteDataResponse>
        get() = _postLecture

    fun postLecture(userid : Long, insurancePostLecture: InsurancePostLecture) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.postLecture(userid, insurancePostLecture)

        if(response.isSuccessful){
            _postLecture.postValue(response.body())
        }
    }

    //인수 심사 리스트 출력 API
    private val _getInsuranceTest = MutableLiveData<InsuranceGetTest>()
    val getInsuranceTest : LiveData<InsuranceGetTest>
        get() = _getInsuranceTest

    fun getInsuranceTest(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getInsuranceTest(userid)

        if(response.isSuccessful){
            _getInsuranceTest.postValue(response.body())
        }
    }

    //인수 심사 수행 API
    private val _patchInsTest = MutableLiveData<InsuranceGetTest>()
    val patchInsTest : LiveData<InsuranceGetTest>
        get() = _patchInsTest

    fun patchInsTest(userid : Long, patchInsTest: PatchInsTest) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.patchInsuranceTest(userid, patchInsTest)

        if(response.isSuccessful){
            _patchInsTest.postValue(response.body())
        }
    }

    //보상금 심사 리스트 출력
    private val _getInsMoneyTest = MutableLiveData<InsuranceMoneyTest>()
    val getInsMoneyTest : LiveData<InsuranceMoneyTest>
        get() = _getInsMoneyTest

    fun getMoneyTest(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getMoneyTest(userid)

        if(response.isSuccessful){
            _getInsMoneyTest.postValue(response.body())
        }
    }

    //보상금 심사 수행 API
    private val _patchMoneyTest = MutableLiveData<InsuranceGetTest>()
    val patchMoneyTest : LiveData<InsuranceGetTest>
        get() = _patchMoneyTest

    fun patchMoneyTest(userid : Long, patchMoneyTest: PatchMoneyTest) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.patchMoneyTest(userid, patchMoneyTest)

        if(response.isSuccessful){
            _patchInsTest.postValue(response.body())
        }
    }

    //상담 대기 신규 고객 리스트 출력
    private val _getInsCustomer = MutableLiveData<InsuranceGetCustomer>()
    val getInsCustomer : LiveData<InsuranceGetCustomer>
        get() = _getInsCustomer

    fun getInsCustomer(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getInsCustomer(userid)

        if(response.isSuccessful){
            _getInsCustomer.postValue(response.body())
        }
    }

    //사고 접수 리스트 출력
    private val _getIncident = MutableLiveData<IncidentGet>()
    val getIncident : LiveData<IncidentGet>
        get() = _getIncident

    fun getIncident(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.getIncidentInfor(userid)

        if(response.isSuccessful){
            _getIncident.postValue(response.body())
        }
    }

    //사고 담당자 배정
    private val _patchIncident = MutableLiveData<IncidentGet>()
    val patchIncident : LiveData<IncidentGet>
        get() = _patchIncident

    fun patchIncident(userid : Long, incident_log_id : Int) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.patchIncidentInfor(userid, incident_log_id)

        if(response.isSuccessful){
            _patchIncident.postValue(response.body())
        }
    }

    //상담사 배정
    private val _postSalesInterest = MutableLiveData<PostInsuranceResponse>()
    val postSalesInterest : LiveData<PostInsuranceResponse>
        get() = _postSalesInterest

    fun postSalesInterest(userid : Long, empCusId : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.postSalesInterest(userid, empCusId)

        if(response.isSuccessful){
            _postSalesInterest.postValue(response.body())
        }
    }



}