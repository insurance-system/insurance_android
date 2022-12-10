package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.GetInsuranceTest
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding

//인수 심사 리스트 어댑터
class InsuranceTestAdapter() : ListAdapter<GetInsuranceTest, InsuranceTestViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceTestViewHolder {
        return InsuranceTestViewHolder(
            ItemCheckCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: InsuranceTestViewHolder, position: Int) {
        val getLectureResult = currentList[position]
        getLectureResult?.let { getInsuranceTest ->
            holder.bind(getInsuranceTest)
            holder.itemView.setOnClickListener {
                onItemClickListener?.let{ it(getInsuranceTest) }
            }
        }
    }

    private var onItemClickListener : ((GetInsuranceTest) -> Unit)? = null
    fun setOnItemClickListener(listener : (GetInsuranceTest) -> Unit){
        onItemClickListener = listener
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetInsuranceTest>(){
            override fun areItemsTheSame(oldItem: GetInsuranceTest, newItem: GetInsuranceTest): Boolean {
                return oldItem.contractId == newItem.contractId
            }

            override fun areContentsTheSame(oldItem: GetInsuranceTest, newItem: GetInsuranceTest): Boolean {
                return oldItem == newItem
            }
        }
    }


}