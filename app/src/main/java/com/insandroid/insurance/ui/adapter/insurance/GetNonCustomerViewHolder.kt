package com.insandroid.insurance.ui.adapter.insurance

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemLastCustomerGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding
import com.insandroid.insurance.databinding.ItemRewardBinding

//사고 접수 뷰홀더
class GetNonCustomerViewHolder( //item_check_customer
    private val binding : ItemLastCustomerGetBinding
) : RecyclerView.ViewHolder(binding.root) {
/*
이름                                          전화번호
주소
날짜
 */
    @SuppressLint("SetTextI18n")
    fun bind(nonPayment: GetNonPayment.NonPayment) {
        binding.customerName.text = "고객 이름 : ${nonPayment.customerName}"
        binding.customerPhone.text = nonPayment.phoneNum
        val kind = when(nonPayment.kindOfInsurance){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }
        binding.insKindOf.text = "보험 종류 : $kind"
        binding.customerJob.text = "직업 : ${nonPayment.kindOfJob}"

        binding.insState.visibility = View.INVISIBLE
        binding.customerInsName.text = "요금 : ${nonPayment.fee}"
    }
/*
        val customerName : String,
        val phoneNum : String,
        val kindOfJob : String,
        val insuranceName : String,
        val fee : Int,
        val kindOfInsurance : String,
 */
}