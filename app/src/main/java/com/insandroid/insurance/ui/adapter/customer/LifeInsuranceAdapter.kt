package com.insandroid.insurance.ui.adapter.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.customer.GetMyInsurance
import com.insandroid.insurance.data.model.customer.MyInsurance
import com.insandroid.insurance.data.model.insurance.GetInsuranceTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetCustomer
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding

//상담 대기 리스트 어댑터
class LifeInsuranceAdapter() : ListAdapter<GetMyInsurance, MyInsuranceViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyInsuranceViewHolder {
        return MyInsuranceViewHolder(
            ItemCheckCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyInsuranceViewHolder, position: Int) {
        val getLectureResult = currentList[position]
        getLectureResult?.let { getInsurance ->
            holder.bind(getInsurance)
            holder.itemView.setOnClickListener {
                onItemClickListener?.let{ it(getInsurance) }
            }
        }

    }

    private var onItemClickListener : ((GetMyInsurance) -> Unit)? = null
    fun setOnItemClickListener(listener : (GetMyInsurance) -> Unit){
        onItemClickListener = listener
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetMyInsurance>(){
            override fun areItemsTheSame(oldItem: GetMyInsurance, newItem: GetMyInsurance): Boolean {
                return oldItem.insuranceId == newItem.insuranceId
            }

            override fun areContentsTheSame(oldItem: GetMyInsurance, newItem: GetMyInsurance): Boolean {
                return oldItem == newItem
            }
        }
    }


}