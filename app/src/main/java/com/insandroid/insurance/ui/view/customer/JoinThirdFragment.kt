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
    private var job : String = ""
    private var insurance : String = ""

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

        //보험 종류
        binding.secondInsurance.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.life -> insurance = "LIFE"
                R.id.non_life -> insurance = "NON_LIFE"
            }
        }

        //직업
        binding.secondJob.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.job_house -> job = "house_maker"
                R.id.job_not -> job = "not_employed"
                R.id.job_office -> job = "office_worker"
                R.id.job_student -> job = "student"
            }
        }

        binding.bt.setOnClickListener {
            if(
                smoke == ""
                || drink == ""
                || cancer == ""
                || job == ""
                || insurance == ""
            ) {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                customerViewModel.updateDrink(drink)
                customerViewModel.updateSmoke(smoke)
                customerViewModel.updateCancer(cancer)
                customerViewModel.updateJob(job)
                customerViewModel.updateInsurance(insurance)

                val action = JoinThirdFragmentDirections.actionFragmentJoinThirdToFragmentJoinFirst()
                findNavController().navigate(action)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}