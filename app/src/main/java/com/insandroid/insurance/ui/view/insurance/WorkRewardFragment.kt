package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkNotCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkRewardBinding
import com.insandroid.insurance.databinding.FragmentWorkSosCheckBinding
import com.insandroid.insurance.ui.adapter.insurance.InsMoneyTestAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsuranceTestAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//보상금 심사 뷰
class WorkRewardFragment: Fragment(){
    private var _binding : FragmentWorkRewardBinding?= null
    private val binding : FragmentWorkRewardBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var insMoneyTestAdapter: InsMoneyTestAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkRewardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getMoneyTest(InsuranceApplication.prefs.getString("id", "").toLong())

        mainViewModel.getInsMoneyTest.observe(viewLifecycleOwner) {
            val result = it.data
            insMoneyTestAdapter.submitList(result)
        }

        setUpRecyclerView()
    }


    private fun setUpRecyclerView(){
        insMoneyTestAdapter = InsMoneyTestAdapter()
        binding.workerRewardRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = insMoneyTestAdapter
        }

        insMoneyTestAdapter.setOnItemClickListener {
            val action  = WorkRewardFragmentDirections.actionFragmentWorkRewardToFragmentWorkRewardDo(it)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}