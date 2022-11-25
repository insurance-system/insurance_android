package com.insandroid.insurance.ui.viewmodel.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.insandroid.insurance.data.repository.customer.CustomerRepository

class CustomerViewModel(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    private val _inputId = MutableLiveData<String>("")
    val inputId: LiveData<String> = _inputId

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

    fun updateInputId(input: String){
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


}