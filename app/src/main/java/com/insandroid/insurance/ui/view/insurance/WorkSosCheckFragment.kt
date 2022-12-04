package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkNotCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkSosCheckBinding

//사고 발생 신고 접수확인 뷰
class WorkSosCheckFragment: Fragment(){
    private var _binding : FragmentWorkSosCheckBinding?= null
    private val binding : FragmentWorkSosCheckBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkSosCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}