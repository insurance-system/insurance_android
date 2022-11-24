package com.insandroid.insurance.ui.viewmodel.insurance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.data.model.insurance.WriteDataResponse
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
    fun insuranceWrite(writeDataRequest: WriteDataRequest) = viewModelScope.launch(Dispatchers.IO) {
        val response = insuranceRepository.insuranceWrite(writeDataRequest)

        if(response.code() == 200){
            _resultWrite.postValue(response.body())
        }
    }
}