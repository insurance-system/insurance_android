package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.databinding.FragmentJoinFirstBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class JoinFirstFragment  : Fragment(){
    private var _binding : FragmentJoinFirstBinding?= null
    private val binding : FragmentJoinFirstBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJoinFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        binding.bt.setOnClickListener {
            if( binding.firstId.text.toString() == ""
                || binding.firstPassword.text.toString() == ""
                || binding.firstName.text.toString() == ""
                || binding.firstAddress.text.toString() == ""
                || binding.firstDetailAddress.text.toString() == ""
                || binding.firstZipcode.text.toString() == ""
            ) {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                customerViewModel.updateInputId(binding.firstId.text.toString())
                customerViewModel.updateInputPw(binding.firstPassword.text.toString())
                customerViewModel.updateInputName(binding.firstName.text.toString())
                customerViewModel.updateInputAddress(binding.firstAddress.text.toString())
                customerViewModel.updateDetailAddress(binding.firstDetailAddress.text.toString())
                customerViewModel.updateZipcode(binding.firstZipcode.text.toString())

                val action =
                    JoinFirstFragmentDirections.actionFragmentJoinFirstToFragmentJoinSecond()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}