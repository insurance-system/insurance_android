package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkNotCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkRewardBinding
import com.insandroid.insurance.databinding.FragmentWorkSosCheckBinding

//보상금 심사 뷰
class WorkRewardFragment: Fragment(){
    private var _binding : FragmentWorkRewardBinding?= null
    private val binding : FragmentWorkRewardBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkRewardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}