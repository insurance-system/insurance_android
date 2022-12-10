package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.insandroid.insurance.databinding.FragmentCusInsJoinBinding
import com.insandroid.insurance.ui.adapter.customer.AccountFindVPAdapter

class CusInsJoinFragment  : Fragment(){
    private var _binding : FragmentCusInsJoinBinding?= null
    private val binding : FragmentCusInsJoinBinding
        get() = _binding!!

    private val accountFindList = arrayListOf("생명보험", "비생명보험")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusInsJoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountFindVPAdapter = AccountFindVPAdapter(this)
        binding.accountFindVp.adapter = accountFindVPAdapter
        TabLayoutMediator(binding.accountFindTb, binding.accountFindVp){
                tab, position ->
            tab.text = accountFindList[position]
        }.attach()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}