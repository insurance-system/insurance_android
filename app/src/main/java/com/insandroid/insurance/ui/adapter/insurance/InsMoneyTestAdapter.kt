package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.data.model.insurance.InsuranceGetTest
import com.insandroid.insurance.data.model.insurance.InsuranceMoneyTest
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemRewardBinding

//보상금 심사 리스트 어댑터
class InsMoneyTestAdapter() : ListAdapter<InsuranceMoneyTest.GetMoneyTest, InsMoneyTestViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsMoneyTestViewHolder {
        return InsMoneyTestViewHolder(
            ItemRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: InsMoneyTestViewHolder, position: Int) {
        val getLectureResult = currentList[position]
        holder.bind(getLectureResult)
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<InsuranceMoneyTest.GetMoneyTest>(){
            override fun areItemsTheSame(oldItem: InsuranceMoneyTest.GetMoneyTest, newItem: InsuranceMoneyTest.GetMoneyTest): Boolean {
                return oldItem.insuranceClaimId == newItem.insuranceClaimId
            }

            override fun areContentsTheSame(oldItem: InsuranceMoneyTest.GetMoneyTest, newItem: InsuranceMoneyTest.GetMoneyTest): Boolean {
                return oldItem == newItem
            }
        }
    }


}