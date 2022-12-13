package com.insandroid.insurance.ui.adapter.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
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

//상담 대기 리스트 어댑터
class ExpireAdapter() : ListAdapter<GetDamageIncident.DamageIncident, ExpireViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpireViewHolder {
        return ExpireViewHolder(
            ItemCheckCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExpireViewHolder, position: Int) {
        val getLectureResult = currentList[position]
//        getLectureResult?.let { getInsurance ->
//            holder.bind(getInsurance)
//            holder.itemView.setOnClickListener {
//                onItemClickListener?.let{ it(getInsurance) }
//            }
//        }

        holder.bind(getLectureResult)
    }
//
//    private var onItemClickListener : ((GetMyInsurance) -> Unit)? = null
//    fun setOnItemClickListener(listener : (GetMyInsurance) -> Unit){
//        onItemClickListener = listener
//    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetDamageIncident.DamageIncident>(){
            override fun areItemsTheSame(oldItem: GetDamageIncident.DamageIncident, newItem: GetDamageIncident.DamageIncident): Boolean {
                return oldItem.customerName == newItem.customerName
            }

            override fun areContentsTheSame(oldItem: GetDamageIncident.DamageIncident, newItem: GetDamageIncident.DamageIncident): Boolean {
                return oldItem == newItem
            }
        }
    }


}