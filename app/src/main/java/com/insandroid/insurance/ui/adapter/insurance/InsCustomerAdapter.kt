package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.GetInsuranceTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetCustomer
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding

//상담 대기 리스트 어댑터
class InsCustomerAdapter() : ListAdapter<InsuranceGetCustomer.GetInsCustomer, InsCustomerViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsCustomerViewHolder {
        return InsCustomerViewHolder(
            ItemNewCustomerGetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: InsCustomerViewHolder, position: Int) {
        val getLectureResult = currentList[position]
//        getLectureResult?.let { getInsuranceTest ->
//            holder.bind(getInsuranceTest)
//            holder.itemView.setOnClickListener {
//                onItemClickListener?.let{ it(getInsuranceTest) }
//            }
//        }
        holder.bind(getLectureResult)
    }

//    private var onItemClickListener : ((GetInsuranceTest) -> Unit)? = null
//    fun setOnItemClickListener(listener : (GetInsuranceTest) -> Unit){
//        onItemClickListener = listener
//    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<InsuranceGetCustomer.GetInsCustomer>(){
            override fun areItemsTheSame(oldItem: InsuranceGetCustomer.GetInsCustomer, newItem: InsuranceGetCustomer.GetInsCustomer): Boolean {
                return oldItem.phoneNum == newItem.phoneNum
            }

            override fun areContentsTheSame(oldItem: InsuranceGetCustomer.GetInsCustomer, newItem: InsuranceGetCustomer.GetInsCustomer): Boolean {
                return oldItem == newItem
            }
        }
    }


}