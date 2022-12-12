package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding

//상담 대기 리스트 어댑터
class InsCustomerAdapter() : ListAdapter<GetInsCustomer, InsCustomerViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsCustomerViewHolder {
        return InsCustomerViewHolder(
            ItemNewCustomerGetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: InsCustomerViewHolder, position: Int) {
        val getLectureResult = currentList[position]

//        getLectureResult?.let { getInsCustomer ->
//            holder.bind(getInsCustomer)
//            holder.itemView.setOnClickListener {
//                onItemClickListener?.let{ it(getInsCustomer) }
//            }
//        }
        holder.bind(getLectureResult)
    }

//    private var onItemClickListener : ((GetInsCustomer) -> Unit)? = null
//    fun setOnItemClickListener(listener : (GetInsCustomer) -> Unit){
//        onItemClickListener = listener
//    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetInsCustomer>(){
            override fun areItemsTheSame(oldItem: GetInsCustomer, newItem: GetInsCustomer): Boolean {
                return oldItem.empCusId == newItem.empCusId
            }

            override fun areContentsTheSame(oldItem: GetInsCustomer, newItem: GetInsCustomer): Boolean {
                return oldItem == newItem
            }
        }
    }


}