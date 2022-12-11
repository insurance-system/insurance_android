package com.insandroid.insurance.ui.adapter.customer

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
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
class LifeInsuranceViewHolder( //item_check_customer
    private val binding : ItemCheckCustomerBinding
) : RecyclerView.ViewHolder(binding.root) {

    /*
      "insuranceId": 0,
      "insuranceName": "string",
      "fee": 0,
      "maxAge": 0,
      "minAge": 0,
      "smoke": "string",
      "alcohol": "string",
      "cancer": "string",
      "kindOfInsurance": "string"
     */
    @SuppressLint("SetTextI18n")
    fun bind(getMyInsurance : GetMyInsurance) {

        val cancer = when (getMyInsurance.cancer) {
            "C" -> "암 1기 이상 투병 중"
            "B" -> "암 1기"
            else -> "암과 관련된 질병 없음"
        }

        val smoke = when(getMyInsurance.smoke){
            "C" -> "하루 1갑 이상"
            "B" -> "하루 담배 10개비 이상 20개 이하"
            else -> "3개 미만 또는 금연"
        }

        val alcohol = when(getMyInsurance.alcohol) {
            "C" -> "일주일 2병 이상"
            "B" -> "일주일 1병 이상, 2병 미만"
            else -> "일주일 1병 미만 또는 금주"
        }

        binding.customerInformation.text = "보험 정보\n" +
                "암 : $cancer\n" +
                "담배 : $smoke\n" +
                "술 : $alcohol"

        val insKindOf = when(getMyInsurance.kindOfInsurance){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }

        val insuranceInformation = "보험 이름 : ${getMyInsurance.insuranceName} \n" +
                "월 청구 비 : ${getMyInsurance.fee} 원\n" +
                "보험 종류 : $insKindOf"

        binding.customerInsInformation.text = insuranceInformation

        binding.insJoin.visibility = View.GONE
    }

    /*

     */
}