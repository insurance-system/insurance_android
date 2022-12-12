package com.insandroid.insurance.ui.adapter.customer

import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.customer.GetPayment
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.databinding.ItemEduGetBinding

//영업 교육 리스트 출력 뷰홀더
class GetPaymentViewHolder(
    private val binding : ItemEduGetBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(paymentHistory: GetPayment.PaymentHistory) {
        binding.eduName.text = "입금 날짜 : ${paymentHistory.payDate}"
        binding.eduUrl.text = "입금 금액 : ${paymentHistory.payCost}원"
    }
}