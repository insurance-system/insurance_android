package com.insandroid.insurance.ui.adapter.insurance

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.insurance.*
import com.insandroid.insurance.databinding.ItemCheckCustomerBinding
import com.insandroid.insurance.databinding.ItemEduGetBinding
import com.insandroid.insurance.databinding.ItemNewCustomerGetBinding
import com.insandroid.insurance.databinding.ItemRewardBinding

//사고 접수 뷰홀더
class IncidentGetViewHolder( //item_check_customer
    private val binding : ItemNewCustomerGetBinding
) : RecyclerView.ViewHolder(binding.root) {
/*
이름                                          전화번호
주소
날짜
 */
    @SuppressLint("SetTextI18n")
    fun bind(getIncidentInfor : GetIncidentInfor) {
        binding.customerJob.text = "사고 날짜 : ${getIncidentInfor.incidentDate}"
        binding.customerInsName.text = getIncidentInfor.incidentSite
        binding.customerName.text = "고객 이름 : ${getIncidentInfor.customerName}"
        binding.customerPhone.text = "전화번호 : ${getIncidentInfor.incidentPhoneNumber}"
    }
/*
    val incidentLogId : Int,
    val customerName : String,
    val incidentPhoneNumber : String,
    val incidentDate : String,
    val incidentSite : String,
    val incidentCategory : String,
 */
}