package com.insandroid.insurance.ui.view.insurance

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
import com.insandroid.insurance.data.model.insurance.InsurancePostLecture
import com.insandroid.insurance.databinding.FragmentWorkEduUploadBinding
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//영업 교육 강의 업로드 뷰
class WorkEduUploadFragment : Fragment(){
    private var _binding : FragmentWorkEduUploadBinding?= null
    private val binding : FragmentWorkEduUploadBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkEduUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        binding.bt.setOnClickListener {
            if(binding.workEduUploadUrlEt.text.toString() == ""
                ||binding.workEduUploadNameEt.text.toString() == ""
            ){
                Toast.makeText(requireContext(), "모두 입력해 주세요.", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                val insurancePostLecture = InsurancePostLecture(
                    lectureName = binding.workEduUploadNameEt.text.toString(),
                    lectureUrl = binding.workEduUploadUrlEt.text.toString()
                )

                mainViewModel.postLecture(InsuranceApplication.prefs.getString("id", "").toLong(), insurancePostLecture)

                Toast.makeText(requireContext(), "영업 교육 업로드 완료하였습니다.", Toast.LENGTH_SHORT)
                    .show()

                val handler = Handler(Looper.getMainLooper())

                handler.postDelayed({
                    findNavController().navigate(R.id.action_fragment_work_edu_upload_to_fragment_work_edu_print)
                }, 1000)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}