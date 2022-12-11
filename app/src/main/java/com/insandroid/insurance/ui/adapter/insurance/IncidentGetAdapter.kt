package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding
import com.insandroid.insurance.databinding.ItemRewardBinding

//사고 접수 어댑터
class IncidentGetAdapter() : ListAdapter<GetIncidentInfor, IncidentGetViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentGetViewHolder {
        return IncidentGetViewHolder(
            ItemNewCustomerGetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: IncidentGetViewHolder, position: Int) {
        val getLectureResult = currentList[position]

        getLectureResult?.let { getMoneyTest ->
            holder.bind(getMoneyTest)
            holder.itemView.setOnClickListener {
                onItemClickListener?.let{ it(getMoneyTest) }
            }
        }
    }

    private var onItemClickListener : ((GetIncidentInfor) -> Unit)? = null
    fun setOnItemClickListener(listener : (GetIncidentInfor) -> Unit){
        onItemClickListener = listener
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<GetIncidentInfor>(){
            override fun areItemsTheSame(oldItem: GetIncidentInfor, newItem: GetIncidentInfor): Boolean {
                return oldItem.incidentLogId == newItem.incidentLogId
            }

            override fun areContentsTheSame(oldItem: GetIncidentInfor, newItem: GetIncidentInfor): Boolean {
                return oldItem == newItem
            }
        }
    }


}