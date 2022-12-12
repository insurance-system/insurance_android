package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.databinding.*

//사고 접수 어댑터
class GetNonCustomerAdapter() : ListAdapter<GetNonPayment.NonPayment, GetNonCustomerViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetNonCustomerViewHolder {
        return GetNonCustomerViewHolder(
            ItemLastCustomerGetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GetNonCustomerViewHolder, position: Int) {
        val getLectureResult = currentList[position]
        holder.bind(getLectureResult)
//        getLectureResult?.let { getMoneyTest ->
//
//            holder.itemView.setOnClickListener {
//                onItemClickListener?.let{ it(getMoneyTest) }
//            }
//        }
    }

//    private var onItemClickListener : ((GetIncidentInfor) -> Unit)? = null
//    fun setOnItemClickListener(listener : (GetIncidentInfor) -> Unit){
//        onItemClickListener = listener
//    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetNonPayment.NonPayment>(){
            override fun areItemsTheSame(oldItem: GetNonPayment.NonPayment, newItem: GetNonPayment.NonPayment): Boolean {
                return oldItem.phoneNum == newItem.phoneNum
            }

            override fun areContentsTheSame(oldItem: GetNonPayment.NonPayment, newItem: GetNonPayment.NonPayment): Boolean {
                return oldItem == newItem
            }
        }
    }


}