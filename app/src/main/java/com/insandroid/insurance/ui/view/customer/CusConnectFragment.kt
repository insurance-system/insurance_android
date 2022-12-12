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
import com.insandroid.insurance.data.model.customer.LineUpConsultRequest
import com.insandroid.insurance.databinding.FragmentCusConnectBinding
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

class CusConnectFragment : Fragment(){
    private var _binding : FragmentCusConnectBinding?= null
    private val binding : FragmentCusConnectBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private var kind : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusConnectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.writeSmokeRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.connect_life -> kind = "LIFE"
                R.id.connect_non_life -> kind = "NON_LIFE"
            }
        }

        customerViewModel = (activity as MainActivity).customerViewModel

        binding.bt.setOnClickListener {
            if(kind == ""){
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else{
                val lineUpConsultRequest = LineUpConsultRequest(
                    kindOfInsurance = kind
                )
                customerViewModel.postConsults(lineUpConsultRequest, InsuranceApplication.prefs.getString("id", "").toLong())

                Toast.makeText(requireContext(), "상담 신청하였습니다.", Toast.LENGTH_SHORT).show()
                val handler = Handler(Looper.getMainLooper())

                handler.postDelayed({
                    findNavController().navigate(R.id.action_fragment_cus_connect_to_fragment_home)
                },1000)
            }
        }



    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}