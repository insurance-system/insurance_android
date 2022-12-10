package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentCusAccidentBinding
import com.insandroid.insurance.databinding.FragmentCusCheckBinding
import com.insandroid.insurance.databinding.FragmentCusLifeInsBinding
import com.insandroid.insurance.databinding.FragmentCusUnlifeInsBinding

class CusUnlifeInsFragment : Fragment(){
    private var _binding : FragmentCusUnlifeInsBinding?= null
    private val binding : FragmentCusUnlifeInsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusUnlifeInsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}