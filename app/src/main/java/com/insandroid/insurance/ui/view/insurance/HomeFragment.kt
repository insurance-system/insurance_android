package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.databinding.FragmentHomeBinding

//홈 화면
class HomeFragment  : Fragment(){
    private var _binding : FragmentHomeBinding?= null
    private val binding : FragmentHomeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //보험 설계 버튼
        binding.fabFavorite.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWrite()
            findNavController().navigate(action)
        }

        //상담 대기 신규 고객 명단 조회 버튼
        binding.homeNewCustomerGetLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkNewCustomer()
            findNavController().navigate(action)
        }

        //영업 교육 강의 업로드
        binding.homeEduUploadLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToWorkEduUploadFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}