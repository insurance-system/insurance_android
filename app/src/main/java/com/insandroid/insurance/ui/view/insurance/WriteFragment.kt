package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.R
import com.insandroid.insurance.data.model.insurance.WriteDataRequest
import com.insandroid.insurance.databinding.FragmentWriteBinding
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.MainActivity

//보험 작성 화면
class WriteFragment : Fragment(){
    private var _binding : FragmentWriteBinding?= null
    private val binding : FragmentWriteBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private var smoke : String = ""
    private var drink : String = ""
    private var cancer : String = ""
    private var kind : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        //흡연
        binding.writeSmokeRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.smoke_2 -> smoke = "A"
                R.id.smoke_1 -> smoke = "B"
                R.id.smoke_0 -> smoke = "C"
            }
        }

        //술
        binding.writeDrinkRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.drink_2 -> drink = "A"
                R.id.drink_1 -> drink = "B"
                R.id.drink_0 -> drink = "C"
            }
        }

        //암
        binding.writeCancerRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.cancer_2 -> cancer = "A"
                R.id.cancer_1 -> cancer = "B"
                R.id.cancer_0 -> cancer = "C"
            }
        }

        //암
        binding.writeKindRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.kind_2 -> kind = "LIFE"
                R.id.kind_1 -> kind = "NON_LIFE"
            }
        }

        binding.bt.setOnClickListener {
            if(smoke == "" || drink == "" || kind == "" || cancer == ""
                || binding.writeInsuranceName.text.toString() == ""
                || binding.writeInsuranceFee.text.toString() == ""
                || binding.writeInsuranceMaxAge.text.toString() == ""
                || binding.writeInsuranceMinAge.text.toString() == ""
                ){
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                val writeDataRequest = WriteDataRequest(
                    insuranceName = binding.writeInsuranceName.text.toString(),
                    fee = binding.writeInsuranceFee.text.toString().toInt(),
                    maxAge = binding.writeInsuranceMaxAge.text.toString().toInt(),
                    minAge = binding.writeInsuranceMinAge.text.toString().toInt(),
                    smoke = smoke,
                    alcohol = drink,
                    cancer = cancer,
                    kindOfInsurance = kind
                )

                mainViewModel.insuranceWrite(writeDataRequest)

                Toast.makeText(requireContext(), "보험설계를 완료하였습니다.", Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())

                handler.postDelayed({
                    findNavController().navigate(R.id.action_fragment_write_to_fragment_home)
                },1000)

            }
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}