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
import com.insandroid.insurance.data.model.customer.PostIncident
import com.insandroid.insurance.databinding.FragmentCusAccidentBinding
import com.insandroid.insurance.databinding.FragmentCusCheckBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class CusAccidentFragment : Fragment(){
    private var _binding : FragmentCusAccidentBinding?= null
    private val binding : FragmentCusAccidentBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private var incident : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusAccidentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        binding.writeSmokeRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.solo -> incident = "단독"
                R.id.car_to_car -> incident = "차대차"
                else -> incident = "차대인"
            }
        }

        binding.bt.setOnClickListener {
            if(binding.cusAccidentDate.text.toString() == ""
                || binding.cusAccidentCarNumber.text.toString() == ""
                || binding.cusAccidentPhone.text.toString() == ""
                || binding.cusAccidentRegion.text.toString() ==""
            ){
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else{
                val postIncident = PostIncident(
                    incidentDate = binding.cusAccidentDate.text.toString(),
                    carNumber = binding.cusAccidentCarNumber.text.toString(),
                    incidentPhoneNumber = binding.cusAccidentPhone.text.toString(),
                    incidentSite = binding.cusAccidentRegion.text.toString(),
                    incidentCategory = incident
                )
                customerViewModel.postIncident(2, postIncident)

                Toast.makeText(requireContext(), "사고 접수되었습니다.", Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())

                handler.postDelayed({
                    findNavController().navigate(R.id.action_fragment_cus_accident_to_fragment_home)
                },1000)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}