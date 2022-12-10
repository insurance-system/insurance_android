package com.insandroid.insurance.ui.adapter.insurance

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.insurance.GetInsuranceTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding

//인수 심사 리스트 뷰홀더
class InsuranceTestViewHolder( //item_check_customer
    private val binding : ItemCheckCustomerBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(getInsuranceTest : GetInsuranceTest) {
        val cancer = when (getInsuranceTest.customerCancer) {
            "C" -> "암 1기 이상 투병 중"
            "B" -> "암 1기"
            else -> "암과 관련된 질병 없음"
        }

        val smoke = when(getInsuranceTest.insuranceSmoke){
            "C" -> "하루 1갑 이상"
            "B" -> "하루 담배 10개비 이상 20개 이하"
            else -> "3개 미만 또는 금연"
        }

        val alcohol = when(getInsuranceTest.customerAlcohol) {
            "C" -> "일주일 2병 이상"
            "B" -> "일주일 1병 이상, 2병 미만"
            else -> "일주일 1병 미만 또는 금주"
        }

        binding.customerInformation.text = "고객 보험 정보\n" +
                "암 : $cancer\n" +
                "담배 : $smoke\n" +
                "술 : $alcohol"

        val insKindOf = when(getInsuranceTest.kindOfInsurance){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }

        val insuranceInformation = "보험 이름 : ${getInsuranceTest.insuranceName} \n" +
                "월 청구 비 : ${getInsuranceTest.insuranceFee} 원\n" +
                "보험 종류 : $insKindOf"

        binding.customerInsInformation.text = insuranceInformation

        val InsCancer = when (getInsuranceTest.insuranceCancer) {
            "C" -> "암 1기 이상 투병 중"
            "B" -> "암 1기"
            else -> "암과 관련된 질병 없음"
        }

        val InsSmoke = when(getInsuranceTest.insuranceSmoke){
            "C" -> "하루 1갑 이상"
            "B" -> "하루 담배 10개비 이상 20개 이하"
            else -> "3개 미만 또는 금연"
        }

        val InsAlcohol = when(getInsuranceTest.insuranceAlcohol) {
            "C" -> "일주일 2병 이상"
            "B" -> "일주일 1병 이상, 2병 미만"
            else -> "일주일 1병 미만 또는 금주"
        }

        binding.insJoin.text = "보험 가입 조건\n" +
                "암 : $InsCancer\n" +
                "담배 : $InsSmoke\n" +
                "술 : $InsAlcohol"

    }
}