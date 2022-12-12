package com.insandroid.insurance.ui.view.insurance

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.insandroid.insurance.data.model.insurance.PatchInsTest
import com.insandroid.insurance.data.model.insurance.PatchMoneyTest
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.databinding.FragmentWorkRewardDoBinding
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

class WorkRewardDoFragment : Fragment(){
    private var _binding : FragmentWorkRewardDoBinding?= null
    private val binding : FragmentWorkRewardDoBinding
        get() = _binding!!

    private val args : WorkRewardDoFragmentArgs by navArgs<WorkRewardDoFragmentArgs>()

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkRewardDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainViewModel = (activity as MainActivity).mainViewModel
        val getMoneyTest = args.getMoneyTest


        binding.workCheckDoName.text = "보험 이름 : ${getMoneyTest.insuranceName}"
        binding.workCheckDoKind.text = "보험 종류 : ${getMoneyTest.kindOfInsurance}"

        binding.bt.setOnClickListener {
            if(binding.writeInsuranceFee.text.toString() == ""){
                Toast.makeText(requireContext(), "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val patchMoneyTest = PatchMoneyTest(
                    insuranceClaimId = getMoneyTest.insuranceClaimId,
                    evaluateFee = binding.writeInsuranceFee.text.toString().toInt()
                )

                mainViewModel.patchMoneyTest(InsuranceApplication.prefs.getString("id", "").toLong(), patchMoneyTest)
                Toast.makeText(requireContext(), "제출 되었습니다.", Toast.LENGTH_SHORT).show()

                val action = WorkRewardDoFragmentDirections.actionFragmentWorkRewardDoToFragmentHome()
                findNavController().navigate(action)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}