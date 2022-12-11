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
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.databinding.FragmentWorkSosDoBinding
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.MainActivity

class WorkSosDoFragment : Fragment(){
    private var _binding : FragmentWorkSosDoBinding?= null
    private val binding : FragmentWorkSosDoBinding
        get() = _binding!!

    private val args : WorkSosDoFragmentArgs by navArgs<WorkSosDoFragmentArgs>()

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkSosDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        val incidentInfor = args.incidentInfor

        binding.workSosDoCustomer.text = incidentInfor.customerName
        binding.workSosDoCustomerPhone.text = incidentInfor.incidentPhoneNumber
        binding.workSosDoDate.text = incidentInfor.incidentDate
        binding.workSosDoSite.text = "사고 장소 : ${incidentInfor.incidentSite}"

        val category = when(incidentInfor.incidentCategory){
            "solo" -> "단독사고"
            "carToCar" -> "차대차"
            else -> "차대인"
        }

        binding.workSosDoKind.text = "사고 종류 : ${category}"

        binding.bt.setOnClickListener {
            mainViewModel.patchIncident(1, incidentInfor.incidentLogId)

            Toast.makeText(requireContext(), "배정 되었습니다.", Toast.LENGTH_SHORT).show()

            val action = WorkSosDoFragmentDirections.actionFragmentWorkSosDoToFragmentHome()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}