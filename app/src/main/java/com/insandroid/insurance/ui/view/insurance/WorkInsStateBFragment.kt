package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentWorkInsStateABinding
import com.insandroid.insurance.databinding.FragmentWorkInsStateBBinding
import com.insandroid.insurance.databinding.FragmentWorkInsStateBinding
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.ui.adapter.insurance.GetNonCustomerAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//보험 계약 상태
class WorkInsStateBFragment : Fragment() {
    private var _binding: FragmentWorkInsStateBBinding? = null
    private val binding: FragmentWorkInsStateBBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var getNonCustomerAdapter : GetNonCustomerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkInsStateBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getInsStateB(InsuranceApplication.prefs.getString("id", "").toLong())

        mainViewModel.getInsStateB.observe(viewLifecycleOwner) {
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
