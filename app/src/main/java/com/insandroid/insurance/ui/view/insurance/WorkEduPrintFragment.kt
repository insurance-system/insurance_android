package com.insandroid.insurance.ui.view.insurance

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentWorkEduPrintBinding
import com.insandroid.insurance.databinding.FragmentWorkEduUploadBinding
import com.insandroid.insurance.ui.adapter.insurance.EduPrintAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.MainActivity

//강의 자료 출력 뷰
class WorkEduPrintFragment : Fragment(){
    private var _binding : FragmentWorkEduPrintBinding?= null
    private val binding : FragmentWorkEduPrintBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var eduPrintAdapter: EduPrintAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkEduPrintBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getLecture(1)

        mainViewModel.getLecture.observe(viewLifecycleOwner) {
            val result = it.data
            eduPrintAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setUpRecyclerView(){
        eduPrintAdapter = EduPrintAdapter()
        binding.workerEduGetRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eduPrintAdapter
        }

    }

}