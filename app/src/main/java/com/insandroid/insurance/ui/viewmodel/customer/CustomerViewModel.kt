package com.insandroid.insurance.ui.viewmodel.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
import com.insandroid.insurance.data.repository.customer.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    //회원가입
    private val _resultJoin = MutableLiveData<JoinDataResponse>()
    val resultJoin : LiveData<JoinDataResponse>
        get() = _resultJoin

    //회원가입 API
    fun customerJoin(joinDataRequest: JoinDataRequest) = viewModelScope.launch(Dispatchers.IO) {
        val response = customerRepository.customerJoin(joinDataRequest)

        if(response.code() == 200){
            _resultJoin.postValue(response.body())
        }
    }

    private val _inputId = MutableLiveData<Int>()
    val inputId: LiveData<Int> = _inputId

    private val _inputPw = MutableLiveData<String>("")
    val inputPw: LiveData<String> = _inputPw

    private val _inputName = MutableLiveData<String>("")
    val inputName: LiveData<String> = _inputName

    private val _inputAddress = MutableLiveData<String>("")
    val inputAddress: LiveData<String> = _inputAddress

    private val _detailAddress = MutableLiveData<String>("")
    val detailAddress: LiveData<String> = _detailAddress

    private val _zipcode = MutableLiveData<String>("")
    val zipcode: LiveData<String> = _zipcode

    private val _phoneNum = MutableLiveData<String>("")
    val phoneNum: LiveData<String> = _phoneNum

    private val _email = MutableLiveData<String>("")
    val email : LiveData<String> = _email

    private val _insurance = MutableLiveData<String>("")
    val insurance: LiveData<String> = _insurance

    private val _job = MutableLiveData<String>("")
    val job: LiveData<String> = _job

    private val _ssn = MutableLiveData<String>("")
    val ssn: LiveData<String> = _ssn

    private val _cancer = MutableLiveData<String>("")
    val cancer : LiveData<String> = _cancer

    private val _drink = MutableLiveData<String>("")
    val drink: LiveData<String> = _drink

    private val _smoke = MutableLiveData<String>("")
    val smoke: LiveData<String> = _smoke

    fun updateInputId(input: Int){
        _inputId.value = input
    }

    fun updateInputPw(input: String){
        _inputPw.value = input
    }

    fun updateInputName(input: String){
        _inputName.value = input
    }

    fun updateInputAddress(input: String){
        _inputAddress.value = input
    }

    fun updateDetailAddress(input: String){
        _detailAddress.value = input
    }

    fun updateZipcode(input: String){
        _zipcode.value = input
    }

    fun updatePhoneNum(input: String){
        _phoneNum.value = input
    }

    fun updateEmail(input: String){
        _email.value = input
    }

    fun updateInsurance(input: String){
        _insurance.value = input
    }

    fun updateJob(input: String){
        _job.value = input
    }

    fun updateSsn(input: String){
        _ssn.value = input
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