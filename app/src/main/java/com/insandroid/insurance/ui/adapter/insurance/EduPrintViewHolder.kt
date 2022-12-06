package com.insandroid.insurance.ui.adapter.insurance

import androidx.recyclerview.widget.RecyclerView
import com.insandroid.insurance.data.model.insurance.InsuranceGetLecture
import com.insandroid.insurance.databinding.ItemEduGetBinding

//홈화면 일단위 음식 조회 리스트뷰 뷰홀더
class EduPrintViewHolder(
    private val binding : ItemEduGetBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(getLectureResult: InsuranceGetLecture.GetLectureResult) {
        binding.eduName.text = getLectureResult.lectureName
        binding.eduUrl.text = getLectureResult.lectureUrl
    }
}