package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentMineBinding
import com.insandroid.insurance.ui.adapter.customer.MyInsuranceAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsMoneyTestAdapter
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.MainActivity

//내 보험 화면
class MineFragment  : Fragment(){
    private var _binding : FragmentMineBinding?= null
    private val binding : FragmentMineBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private lateinit var myInsuranceAdapter : MyInsuranceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        customerViewModel.getMyInsurance(2)

        customerViewModel.myInsurance.observe(viewLifecycleOwner) {
            val result = it.data
            myInsuranceAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        myInsuranceAdapter = MyInsuranceAdapter()
        binding.workerEduGetRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = myInsuranceAdapter
        }

        myInsuranceAdapter.setOnItemClickListener {
            val action  = MineFragmentDirections.actionFragmentMineToFragmentCusInsMoney(it)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}