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
import androidx.navigation.fragment.navArgs
import com.insandroid.insurance.R
import com.insandroid.insurance.data.model.customer.PostMoney
import com.insandroid.insurance.databinding.FragmentCusCheckBinding
import com.insandroid.insurance.databinding.FragmentCusInsMoneyBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

class CusInsMoneyFragment : Fragment(){
    private var _binding : FragmentCusInsMoneyBinding?= null
    private val binding : FragmentCusInsMoneyBinding
        get() = _binding!!

    private val args : CusInsMoneyFragmentArgs by navArgs<CusInsMoneyFragmentArgs>()

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCusInsMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customerViewModel = (activity as MainActivity).customerViewModel

        val insurance = args.insurance

        binding.cusInsName.text = "보험 이름 : ${insurance.insuranceName}"

        binding.bt.setOnClickListener {
            val postMoney = PostMoney(
                insuranceId = insurance.insuranceId,
                claimContent = binding.cusAccidentRegion.text.toString(),
                claimCost = binding.cusInsMoney.text.toString().toInt()
            )

            customerViewModel.postMoney(InsuranceApplication.prefs.getString("id", "").toLong(), postMoney)

            Toast.makeText(requireContext(), "보험금 신청하였습니다.", Toast.LENGTH_SHORT).show()
            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                findNavController().navigate(R.id.action_fragment_cus_ins_money_to_fragment_mine)
            },1000)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}