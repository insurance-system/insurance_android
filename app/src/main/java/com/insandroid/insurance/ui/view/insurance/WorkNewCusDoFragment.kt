package com.insandroid.insurance.ui.view.insurance

import android.annotation.SuppressLint
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
import com.insandroid.insurance.databinding.FragmentSettingBinding
import com.insandroid.insurance.databinding.FragmentWorkNewCusDoBinding
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

class WorkNewCusDoFragment : Fragment(){
    private var _binding : FragmentWorkNewCusDoBinding?= null
    private val binding : FragmentWorkNewCusDoBinding
        get() = _binding!!

    private val args : WorkNewCusDoFragmentArgs by navArgs<WorkNewCusDoFragmentArgs>()

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkNewCusDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        val customerId = args.id
        val name = args.name
        val phone = args.phone
        val kind = args.kind

        val kind2 = when(kind){
            "LIFE" -> "생명보험"
            else -> "비생명보험"
        }

        binding.workerCusDoName.text = "고객 이름 : ${name}"
        binding.workerCusDoPhone.text = "전화 번호 : ${phone}"
        binding.workerCusDoKind.text = "보험 종류 : $kind2"

        binding.bt.setOnClickListener {
            mainViewModel.postSalesInterest(InsuranceApplication.prefs.getString("id", "").toLong(), customerId)

            Toast.makeText(requireContext(), "상담사가 배정되었습니다..", Toast.LENGTH_SHORT).show()
            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                findNavController().navigate(R.id.action_fragment_work_new_cus_do_to_fragment_home)
            },1000)
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}