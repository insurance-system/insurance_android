package com.insandroid.insurance.ui.adapter.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.customer.GetPayment
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.databinding.ItemEduGetBinding

//영업 교육 리스트 출력 어댑터
class GetPaymentAdapter() : ListAdapter<GetPayment.PaymentHistory, GetPaymentViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetPaymentViewHolder {
        return GetPaymentViewHolder(
            ItemEduGetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GetPaymentViewHolder, position: Int) {
        val getLectureResult = currentList[position]
        holder.bind(getLectureResult)
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetPayment.PaymentHistory>(){
            override fun areItemsTheSame(oldItem: GetPayment.PaymentHistory, newItem: GetPayment.PaymentHistory): Boolean {
                return oldItem.paymentId == newItem.paymentId
            }

            override fun areContentsTheSame(oldItem: GetPayment.PaymentHistory, newItem: GetPayment.PaymentHistory): Boolean {
                return oldItem == newItem
            }
        }
    }


}