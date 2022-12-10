package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemRewardBinding

//보상금 심사 리스트 어댑터
class InsMoneyTestAdapter() : ListAdapter<GetMoneyTest, InsMoneyTestViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsMoneyTestViewHolder {
        return InsMoneyTestViewHolder(
            ItemRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: InsMoneyTestViewHolder, position: Int) {
        val getLectureResult = currentList[position]

        getLectureResult?.let { getMoneyTest ->
            holder.bind(getMoneyTest)
            holder.itemView.setOnClickListener {
                onItemClickListener?.let{ it(getMoneyTest) }
            }
        }
    }

    private var onItemClickListener : ((GetMoneyTest) -> Unit)? = null
    fun setOnItemClickListener(listener : (GetMoneyTest) -> Unit){
        onItemClickListener = listener
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetMoneyTest>(){
            override fun areItemsTheSame(oldItem: GetMoneyTest, newItem: GetMoneyTest): Boolean {
                return oldItem.insuranceClaimId == newItem.insuranceClaimId
            }

            override fun areContentsTheSame(oldItem: GetMoneyTest, newItem: GetMoneyTest): Boolean {
                return oldItem == newItem
            }
        }
    }


}