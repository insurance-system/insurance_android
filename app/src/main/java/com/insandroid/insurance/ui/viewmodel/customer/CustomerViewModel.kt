package com.insandroid.insurance.ui.viewmodel.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.insandroid.insurance.data.repository.customer.CustomerRepository

class CustomerViewModel(
    private val customerRepository: CustomerRepository
) : ViewModel() {

    private val _currentInputId = MutableLiveData<String>("")
    val currentInputId: LiveData<String> = _currentInputId

    private val _currentInputPw = MutableLiveData<String>("")
    val currentInputPw: LiveData<String> = _currentInputPw

    fun updateInputId(input: String){
        _currentInputId.value = input
    }

    fun updateInputPw(input: String){
        _currentInputPw.value = input
    }


}