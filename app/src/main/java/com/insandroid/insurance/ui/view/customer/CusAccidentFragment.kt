package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentCusAccidentBinding
import com.insandroid.insurance.databinding.FragmentCusCheckBinding

class CusAccidentFragment : Fragment(){
    private var _binding : FragmentCusAccidentBinding?= null
    private val binding : FragmentCusAccidentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusAccidentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}