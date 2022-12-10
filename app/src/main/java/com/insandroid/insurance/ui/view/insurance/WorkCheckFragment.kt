package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.databinding.FragmentWorkCheckBinding
import com.insandroid.insurance.ui.adapter.insurance.EduPrintAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsuranceTestAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.MainActivity

//인수 심사 리스트 뷰
class WorkCheckFragment : Fragment(){
    private var _binding : FragmentWorkCheckBinding?= null
    private val binding : FragmentWorkCheckBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var insuranceTestAdapter: InsuranceTestAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getInsuranceTest(1)

        mainViewModel.getInsuranceTest.observe(viewLifecycleOwner) {
            val result = it.data
            insuranceTestAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        insuranceTestAdapter = InsuranceTestAdapter()
        binding.workerCheckRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = insuranceTestAdapter
        }

        insuranceTestAdapter.setOnItemClickListener {
            val action  = WorkCheckFragmentDirections.actionFragmentWorkCheckToFragmentWorkCheckDo(it)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}