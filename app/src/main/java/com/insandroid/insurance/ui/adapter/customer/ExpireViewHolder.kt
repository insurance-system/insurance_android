package com.insandroid.insurance.ui.adapter.customer

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.customer.GetDamageIncident
import com.insandroid.insurance.data.model.customer.GetMyInsurance
import com.insandroid.insurance.data.model.customer.MyInsurance
import com.insandroid.insurance.data.model.insurance.GetInsuranceTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetCustomer
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding

//상담 대기 리스트 뷰홀더
class ExpireViewHolder( //item_check_customer
    private val binding : ItemCheckCustomerBinding
) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("SetTextI18n")
    fun bind(damageIncident : GetDamageIncident.DamageIncident) {
        binding.customerInformation.text = "고객 이름 : ${damageIncident.customerName} 전화번호 : ${damageIncident.phoneNum}"
        binding.customerInsInformation.text = "담당자 이름 : ${damageIncident.empName}"
        binding.insJoin.text = "담당자 전화번호 : ${damageIncident.empPhoneNum}"
    }

    /*

     */
}