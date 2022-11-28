package com.insandroid.insurance.ui.view.customer

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
import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.databinding.FragmentJoinThirdBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class JoinThirdFragment : Fragment(){
    private var _binding : FragmentJoinThirdBinding?= null
    private val binding : FragmentJoinThirdBinding
        get() = _binding!!

    private var smoke : String = ""
    private var drink : String = ""
    private var cancer : String = ""

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJoinThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

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

        binding.bt.setOnClickListener {
            if( binding.secondSsn.text.toString() == ""
                || smoke == ""
                || drink == ""
                || cancer == ""
            ) {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                customerViewModel.updateSsn(binding.secondSsn.text.toString())
                customerViewModel.updateDrink(drink)
                customerViewModel.updateSmoke(smoke)
                customerViewModel.updateCancer(cancer)

                val joinDataRequest = JoinDataRequest(
                    customerId = customerViewModel.inputId.value,
                    password = customerViewModel.inputPw.value,
                    name = customerViewModel.inputName.value,
                    address = customerViewModel.inputAddress.value,
                    detailAddress = customerViewModel.detailAddress.value,
                    zipcode = customerViewModel.zipcode.value,
                    email = customerViewModel.email.value,
                    phoneNumber = customerViewModel.phoneNum.value,
                    kindOfJob = customerViewModel.job.value,
                    kindOfInsurance = customerViewModel.insurance.value,
                    ssn = customerViewModel.ssn.value,
                    cancer = customerViewModel.cancer.value,
                    smoke = customerViewModel.smoke.value,
                    alcohol = customerViewModel.drink.value
                )

                customerViewModel.customerJoin(joinDataRequest)

                Toast.makeText(requireContext(), "회원가입을 완료하였습니다.", Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())

                handler.postDelayed({
                    findNavController().navigate(R.id.action_fragment_join_third_to_fragment_home)
                },1000)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}