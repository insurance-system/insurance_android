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
import com.insandroid.insurance.ui.adapter.customer.LifeInsuranceAdapter
import com.insandroid.insurance.ui.adapter.customer.MyInsuranceAdapter
import com.insandroid.insurance.ui.adapter.customer.NonInsuranceAdapter
import com.insandroid.insurance.ui.view.insurance.WorkRewardFragmentDirections
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class CusLifeInsFragment : Fragment(){
    private var _binding : FragmentCusLifeInsBinding?= null
    private val binding : FragmentCusLifeInsBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private lateinit var lifeInsuranceAdapter: LifeInsuranceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusLifeInsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        customerViewModel.getInsurance(4, "LIFE")

        customerViewModel.getInsurance.observe(viewLifecycleOwner) {
            val result = it.data
            lifeInsuranceAdapter.submitList(result)
        }
        setUpRecyclerView()

        println("gg")
    }

    private fun setUpRecyclerView(){
        lifeInsuranceAdapter = LifeInsuranceAdapter()
        binding.workerEduGetRv1.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = lifeInsuranceAdapter
        }
        lifeInsuranceAdapter.setOnItemClickListener {
            val action  = CusInsJoinFragmentDirections.actionFragmentCusInsJoinToFragmentCusInsDo(it)
            findNavController().navigate(action)
        }

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}