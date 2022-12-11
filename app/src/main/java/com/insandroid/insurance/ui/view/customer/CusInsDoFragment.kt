package com.insandroid.insurance.ui.view.customer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.insandroid.insurance.R
import com.insandroid.insurance.data.model.customer.PostInsurance
import com.insandroid.insurance.data.model.customer.PostInsuranceResponse
import com.insandroid.insurance.databinding.FragmentCusInsDoBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class CusInsDoFragment : Fragment(){
    private var _binding : FragmentCusInsDoBinding?= null
    private val binding : FragmentCusInsDoBinding
        get() = _binding!!

    private val args : CusInsDoFragmentArgs by navArgs<CusInsDoFragmentArgs>()

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusInsDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        val insurance = args.insurance

        val kindOf = when(insurance.kindOfInsurance){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }

        binding.workCheckDoName.text = "보험 이름 : ${insurance.insuranceName}"
        binding.workCheckDoKind.text = "보험 종류 : $kindOf"

        binding.bt.setOnClickListener {
            val postInsurance = PostInsurance(
                insuranceId = insurance.insuranceId
            )

            customerViewModel.postInsurance(postInsurance, 2)

            Toast.makeText(requireContext(), "보험 신청되었습니다.", Toast.LENGTH_SHORT).show()
            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                findNavController().navigate(R.id.action_fragment_cus_ins_do_to_fragment_home)
            },1000)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}