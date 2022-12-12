package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.databinding.FragmentWorkInsStateBinding
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding

//보험 계약 상태
class WorkInsStateFragment : Fragment() {
    private var _binding: FragmentWorkInsStateBinding? = null
    private val binding: FragmentWorkInsStateBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkInsStateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.workerLastMoneyLl.setOnClickListener {
            val action = WorkInsStateFragmentDirections.actionFragmentWorkInsStateToFragmentWorkInsStateB()
            findNavController().navigate(action)
        }

        binding.workerLastContractLl.setOnClickListener {
            val action = WorkInsStateFragmentDirections.actionFragmentWorkInsStateToFragmentWorkInsStateA()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
