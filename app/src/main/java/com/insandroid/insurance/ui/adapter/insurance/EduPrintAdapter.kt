package com.insandroid.insurance.ui.adapter.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.databinding.ItemEduGetBinding

//영업 교육 리스트 출력 어댑터
class EduPrintAdapter() : ListAdapter<InsuranceGetLecture.GetLectureResult, EduPrintViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EduPrintViewHolder {
        return EduPrintViewHolder(
            ItemEduGetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EduPrintViewHolder, position: Int) {
        val getLectureResult = currentList[position]
        holder.bind(getLectureResult)
    }

    companion object{
        private val BookDiffCallback = object : DiffUtil.ItemCallback<InsuranceGetLecture.GetLectureResult>(){
            override fun areItemsTheSame(oldItem: InsuranceGetLecture.GetLectureResult, newItem: InsuranceGetLecture.GetLectureResult): Boolean {
                return oldItem.lectureName == newItem.lectureName
            }

            override fun areContentsTheSame(oldItem: InsuranceGetLecture.GetLectureResult, newItem: InsuranceGetLecture.GetLectureResult): Boolean {
                return oldItem == newItem
            }
        }
    }


}