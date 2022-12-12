package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentCusAccidentBinding
import com.insandroid.insurance.databinding.FragmentCusCheckBinding
import com.insandroid.insurance.databinding.FragmentCusLifeInsBinding
import com.insandroid.insurance.databinding.FragmentCusUnlifeInsBinding
import com.insandroid.insurance.ui.adapter.customer.MyInsuranceAdapter
import com.insandroid.insurance.ui.adapter.customer.NonInsuranceAdapter
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

class CusUnlifeInsFragment : Fragment(){
    private var _binding : FragmentCusUnlifeInsBinding?= null
    private val binding : FragmentCusUnlifeInsBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private lateinit var nonInsuranceAdapter: NonInsuranceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusUnlifeInsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        customerViewModel.getNonInsurance(InsuranceApplication.prefs.getString("id", "").toLong(), "NON_LIFE")

        customerViewModel.getNonInsurance.observe(viewLifecycleOwner) {
            val result = it.data
            nonInsuranceAdapter.submitList(result)
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        nonInsuranceAdapter = NonInsuranceAdapter()
        binding.workerEduGetRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = nonInsuranceAdapter
        }
        nonInsuranceAdapter.setOnItemClickListener {
            val action  = CusInsJoinFragmentDirections.actionFragmentCusInsJoinToFragmentCusInsDo(it)
            findNavController().navigate(action)
        }

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}