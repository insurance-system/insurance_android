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

        //관리자 뷰
        //보험 설계 버튼
        binding.fabFavorite.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWrite()
            findNavController().navigate(action)
        }

        //상담 대기 신규 고객 명단 조회
        binding.homeNewCustomerGetLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkNewCustomer()
            findNavController().navigate(action)
        }

        //영업 교육 강의 업로드
        binding.homeEduUploadLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToWorkEduUploadFragment()
            findNavController().navigate(action)
        }

        //강의 자료 리스트 출력
        binding.homeEduPrintLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkEduPrint()
            findNavController().navigate(action)
        }

        //보험 계약 상태
        binding.homeInsStateLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkInsState()
            findNavController().navigate(action)
        }

        //보험 만기 고객 조회
        binding.homeLastCustomerGetLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkLastCustomer()
            findNavController().navigate(action)
        }

        //미납 고객 조회
        binding.homeNotCustomerGetLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkNotCustomer()
            findNavController().navigate(action)
        }

        //사고 발생 신고 접수확인
        binding.homeAccidentCheckLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkSosCheck()
            findNavController().navigate(action)
        }

        //보상금 심사
        binding.homeMoneyCheckLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentWorkReward()
            findNavController().navigate(action)
        }


        //사용자뷰
        //상담사 평가하기
        binding.customerEvaluationLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentCusEvaluation()
            findNavController().navigate(action)
        }

        //보험급 납부 내역 확인
        binding.customerMoneyCheckLl.setOnClickListener {
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentCusCheck()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}