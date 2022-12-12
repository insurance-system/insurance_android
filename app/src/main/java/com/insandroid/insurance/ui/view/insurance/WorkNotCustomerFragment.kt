package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkNotCustomerBinding
import com.insandroid.insurance.ui.adapter.insurance.GetNonCustomerAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsCustomerAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//미납 고객 조회 뷰
class WorkNotCustomerFragment: Fragment(){
    private var _binding : FragmentWorkNotCustomerBinding?= null
    private val binding : FragmentWorkNotCustomerBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var getNonCustomerAdapter : GetNonCustomerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkNotCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getNonPayment(InsuranceApplication.prefs.getString("id", "").toLong())

        mainViewModel.getNonPayment.observe(viewLifecycleOwner) {
            val result = it.data
            getNonCustomerAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        getNonCustomerAdapter = GetNonCustomerAdapter()
        binding.workerNotCustomerRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = getNonCustomerAdapter
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