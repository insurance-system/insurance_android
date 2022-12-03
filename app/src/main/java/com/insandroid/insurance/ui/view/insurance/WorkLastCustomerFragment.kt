package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentWorkLastCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding

//보험 만기 고객 조회
class WorkLastCustomerFragment : Fragment(){
    private var _binding : FragmentWorkLastCustomerBinding?= null
    private val binding : FragmentWorkLastCustomerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkLastCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}