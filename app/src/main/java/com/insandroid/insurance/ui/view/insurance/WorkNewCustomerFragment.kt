package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.ui.adapter.insurance.EduPrintAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsCustomerAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//상담 대기 신규 고객 명단 조회 뷰
class WorkNewCustomerFragment: Fragment(){
    private var _binding : FragmentWorkNewCustomerBinding?= null
    private val binding : FragmentWorkNewCustomerBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var insCustomerAdapter : InsCustomerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkNewCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getInsCustomer(InsuranceApplication.prefs.getString("id", "").toLong())

        mainViewModel.getInsCustomer.observe(viewLifecycleOwner) {
            val result = it.data
            insCustomerAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        insCustomerAdapter = InsCustomerAdapter()
        binding.workerNewCustomerRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = insCustomerAdapter
        }
//        insCustomerAdapter.setOnItemClickListener {
//            val action  = WorkNewCustomerFragmentDirections.actionFragmentWorkNewCustomerToFragmentWorkNewCusDo(it)
//            findNavController().navigate(action)
//        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}