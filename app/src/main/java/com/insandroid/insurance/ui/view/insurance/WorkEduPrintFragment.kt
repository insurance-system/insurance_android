package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentWorkEduPrintBinding
import com.insandroid.insurance.databinding.FragmentWorkEduUploadBinding

//강의 자료 출력 뷰
class WorkEduPrintFragment : Fragment(){
    private var _binding : FragmentWorkEduPrintBinding?= null
    private val binding : FragmentWorkEduPrintBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkEduPrintBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}