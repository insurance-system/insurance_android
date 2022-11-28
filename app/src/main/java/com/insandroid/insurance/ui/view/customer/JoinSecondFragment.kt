package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.R
import com.insandroid.insurance.databinding.FragmentJoinSecondBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class JoinSecondFragment  : Fragment(){
    private var _binding : FragmentJoinSecondBinding?= null
    private val binding : FragmentJoinSecondBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

//    private val customerViewModel : CustomerViewModel by activityViewModels()

    private var job : String = ""
    private var insurance : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJoinSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

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
            if( binding.secondEmail.text.toString() == ""
                || binding.secondPhone.text.toString() == ""
                || job == ""
                || insurance == ""
            ) {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
                customerViewModel.updatePhoneNum(binding.secondPhone.text.toString())
                customerViewModel.updateEmail(binding.secondEmail.text.toString())
                customerViewModel.updateJob(job)
                customerViewModel.updateInsurance(insurance)

                val action =
                    JoinSecondFragmentDirections.actionFragmentJoinSecondToFragmentJoinThird()
                findNavController().navigate(action)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}