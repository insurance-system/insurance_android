package com.insandroid.insurance.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.insandroid.insurance.data.repository.InsuranceRepository

class MainViewModelProviderFactory(
    private val insuranceRepository: InsuranceRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(insuranceRepository) as T
        }
        throw IllegalArgumentException("viewmodel name is error")
    }
}