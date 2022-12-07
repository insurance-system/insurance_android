package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentCusEvaluationBinding
import com.insandroid.insurance.databinding.FragmentSettingBinding

//상담사 평가하기 뷰
class CusEvaluationFragment  : Fragment(){
    private var _binding : FragmentCusEvaluationBinding?= null
    private val binding : FragmentCusEvaluationBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusEvaluationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}