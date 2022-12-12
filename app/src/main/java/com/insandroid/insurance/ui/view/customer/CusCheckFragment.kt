package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentCusCheckBinding
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.ui.adapter.customer.GetPaymentAdapter
import com.insandroid.insurance.ui.adapter.customer.NonInsuranceAdapter
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//보험급 납부 내역 확인 뷰
class CusCheckFragment : Fragment(){
    private var _binding : FragmentCusCheckBinding?= null
    private val binding : FragmentCusCheckBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private lateinit var getPaymentAdapter: GetPaymentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        customerViewModel.getPayment(InsuranceApplication.prefs.getString("id", "").toLong())

        customerViewModel.getPayment.observe(viewLifecycleOwner) {
            val result = it.data
            getPaymentAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        getPaymentAdapter = GetPaymentAdapter()
        binding.cusCheckRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = getPaymentAdapter
        }

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}