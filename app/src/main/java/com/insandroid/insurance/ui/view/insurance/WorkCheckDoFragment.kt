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
import com.insandroid.insurance.R
import com.insandroid.insurance.data.model.insurance.PatchInsTest
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.databinding.FragmentWorkCheckDoBinding
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity


class WorkCheckDoFragment : Fragment(){
    private var _binding : FragmentWorkCheckDoBinding?= null
    private val binding : FragmentWorkCheckDoBinding
        get() = _binding!!

    private val args : WorkCheckDoFragmentArgs by navArgs<WorkCheckDoFragmentArgs>()

    private var insState : String = ""

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkCheckDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        val getInsuranceTest = args.insurance

        val insKindOf = when(getInsuranceTest.kindOfInsurance){
            "NON_LIFE" -> "비생명"
            else -> "생명"
        }

        binding.workCheckDoName.text = "보험이름 : ${getInsuranceTest.insuranceName}"
        binding.workCheckDoFee.text = "보험비 : ${getInsuranceTest.insuranceFee}"
        binding.workCheckDoKind.text = "보험종류 : $insKindOf"

        binding.workCheckDoRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.ing -> insState = "인수심사 진행중"
                R.id.good -> insState = "정상"
                R.id.reject -> insState = "인수심사 거절"
            }
        }

        binding.bt.setOnClickListener {
            if(insState == ""){
                Toast.makeText(requireContext(), "체크 해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                val patchInsTest = PatchInsTest(
                    contractId = getInsuranceTest.contractId,
                    contractStatus = insState
                )

                mainViewModel.patchInsTest(InsuranceApplication.prefs.getString("id", "").toLong(), patchInsTest)
                Toast.makeText(requireContext(), "제출 되었습니다.", Toast.LENGTH_SHORT).show()

                val action = WorkCheckDoFragmentDirections.actionFragmentWorkCheckDoToFragmentHome()
                findNavController().navigate(action)
            }
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}