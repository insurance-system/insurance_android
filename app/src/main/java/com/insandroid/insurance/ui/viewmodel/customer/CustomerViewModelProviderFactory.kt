package com.insandroid.insurance.ui.viewmodel.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.insandroid.insurance.data.repository.customer.CustomerRepository

class CustomerViewModelProviderFactory(
    private val customerRepository: CustomerRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CustomerViewModel::class.java)) {
            return CustomerViewModel(customerRepository) as T
        }
        throw IllegalArgumentException("viewmodel name is error")
    }
}