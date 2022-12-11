package com.insandroid.insurance.ui.viewmodel.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.insandroid.insurance.data.model.customer.*
import com.insandroid.insurance.data.repository.customer.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    //회원가입
//    private val _resultJoin = MutableLiveData<JoinDataResponse>()
//    val resultJoin : LiveData<JoinDataResponse>
//        get() = _resultJoin

    //회원가입 API
    fun customerJoin(joinDataRequest: JoinDataRequest) = customerRepository.customerJoin(joinDataRequest)

    //보험된 가입 정보 불러오기
    private val _myInsurance = MutableLiveData<MyInsurance>()
    val myInsurance : LiveData<MyInsurance>
        get() = _myInsurance

    fun getMyInsurance(userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.getMyInsurance(userid)

        if(response.isSuccessful){
            _myInsurance.postValue(response.body())
        }
    }

    //가입 신청하기
    private val _postInsurance = MutableLiveData<PostInsuranceResponse>()
    val postInsurance : LiveData<PostInsuranceResponse>
        get() = _postInsurance

    fun postInsurance(postInsurance : PostInsurance, userid : Long) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.postInsurance(postInsurance, userid)

        if(response.isSuccessful){
            _postInsurance.postValue(response.body())
        }
    }

    //LIFE 보험 정보 불러오기
    private val _getInsurance = MutableLiveData<MyInsurance>()
    val getInsurance : LiveData<MyInsurance>
        get() = _getInsurance

    fun getInsurance(userid : Long, insuranceKind : String) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.getInsurance(userid, insuranceKind)

        if(response.isSuccessful){
            _getInsurance.postValue(response.body())
        }
    }

    //NON_LIFE 보험 정보 불러오기
    private val _getNonInsurance = MutableLiveData<MyInsurance>()
    val getNonInsurance : LiveData<MyInsurance>
        get() = _getNonInsurance

    fun getNonInsurance(userid : Long, insuranceKind : String) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.getInsurance(userid, insuranceKind)

        if(response.isSuccessful){
            _getNonInsurance.postValue(response.body())
        }
    }

    //보험금 청구하기
    private val _postMoney = MutableLiveData<PostMoneyResponse>()
    val postMoney : LiveData<PostMoneyResponse>
        get() = _postMoney

    fun postMoney(userid : Long, postMoney: PostMoney) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.postMoneyInsurance(userid, postMoney)

        if(response.isSuccessful){
            _postMoney.postValue(response.body())
        }
    }

    //사고처리접수
    private val _postIncident = MutableLiveData<PostMoneyResponse>()
    val postIncident : LiveData<PostMoneyResponse>
        get() = _postIncident

    fun postIncident(userid : Long, postIncident: PostIncident) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.postIncident(userid, postIncident)

        if(response.isSuccessful){
            _postIncident.postValue(response.body())
        }
    }

    private val _insurance = MutableLiveData<String>("")
    val insurance: LiveData<String> = _insurance

    private val _job = MutableLiveData<String>("")
    val job: LiveData<String> = _job

    private val _cancer = MutableLiveData<String>("")
    val cancer : LiveData<String> = _cancer

    private val _drink = MutableLiveData<String>("")
    val drink: LiveData<String> = _drink

    private val _smoke = MutableLiveData<String>("")
    val smoke: LiveData<String> = _smoke

    fun updateInsurance(input: String){
        _insurance.value = input
    }

    fun updateJob(input: String){
        _job.value = input
    }

    fun updateCancer(input: String){
        _cancer.value = input
    }

    fun updateSmoke(input: String){
        _smoke.value = input
    }

    fun updateDrink(input: String){
        _drink.value = input
    }


}