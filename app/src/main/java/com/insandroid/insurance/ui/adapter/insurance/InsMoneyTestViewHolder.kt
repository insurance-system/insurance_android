package com.insandroid.insurance.ui.adapter.insurance

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.insurance.GetMoneyTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.data.model.insurance.InsuranceMoneyTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemRewardBinding

//보상금 심사 리스트 뷰홀더
class InsMoneyTestViewHolder( //item_check_customer
    private val binding : ItemRewardBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(getInsMoney : GetMoneyTest) {
        binding.checkInformation.text = "심사 내용 : ${getInsMoney.claimContent}"

        val insKindOf = when(getInsMoney.kindOfInsurance){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }

        val insInformation = "보험 이름 : ${getInsMoney.insuranceName} \n" +
                "보험 비용 : ${getInsMoney.claimCost} 원 \n" +
                "보험 종류 : $insKindOf"

        binding.customerMoney.text = insInformation

        binding.customerInformation.text = "고객 이름 : ${getInsMoney.customerName}"
    }
    /*
        {
      "insuranceClaimId": 0,
      "claimContent": "string",
      "claimCost": 0,
      "customerName": "string",
      "insuranceName": "string",
      "kindOfInsurance": "string"
    }
     */
}