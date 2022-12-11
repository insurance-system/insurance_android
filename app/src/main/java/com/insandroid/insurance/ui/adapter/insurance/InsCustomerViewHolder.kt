package com.insandroid.insurance.ui.adapter.insurance

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.insurance.GetInsuranceTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetCustomer
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding

//상담 대기 리스트 뷰홀더
class InsCustomerViewHolder( //item_check_customer
    private val binding : ItemNewCustomerGetBinding
) : RecyclerView.ViewHolder(binding.root) {

    /*
            val customerName : String,
        val phoneNum : String,
        val kindOfInsurance : String,
        val kindOfJob : String
     */
    @SuppressLint("SetTextI18n")
    fun bind(getInsCustomer : InsuranceGetCustomer.GetInsCustomer) {
        binding.customerName.text = "고객 이름 : ${getInsCustomer.customerName}"
        binding.customerPhone.text = getInsCustomer.phoneNum
        binding.customerJob.text = getInsCustomer.kindOfJob

        val insKindOf = when(getInsCustomer.kindOfInsurance){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }

        binding.customerInsName.text = "관심 보험 : ${insKindOf}"
    }

    /*
    고객 이름                                         전화
    관심보험종류                                 직종

     */
}