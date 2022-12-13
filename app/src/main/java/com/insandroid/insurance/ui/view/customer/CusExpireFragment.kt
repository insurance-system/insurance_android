package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentCusExpireBinding
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.ui.adapter.customer.ExpireAdapter
import com.insandroid.insurance.ui.adapter.customer.LifeInsuranceAdapter
import com.insandroid.insurance.ui.adapter.customer.NonInsuranceAdapter
import com.insandroid.insurance.ui.view.insurance.SettingFragmentDirections
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

class CusExpireFragment : Fragment(){
    private var _binding : FragmentCusExpireBinding?= null
    private val binding : FragmentCusExpireBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private lateinit var expireAdapter : ExpireAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusExpireBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        customerViewModel.getDamageIncident(InsuranceApplication.prefs.getString("id", "").toLong())

        customerViewModel.getDamageIncident.observe(viewLifecycleOwner) {
            val result = it.data
            expireAdapter.submitList(result)
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        expireAdapter = ExpireAdapter()
        binding.workerEduGetRv1.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = expireAdapter
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}