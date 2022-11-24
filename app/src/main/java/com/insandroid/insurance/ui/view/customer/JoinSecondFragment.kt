package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insandroid.insurance.databinding.FragmentJoinSecondBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity

class JoinSecondFragment  : Fragment(){
    private var _binding : FragmentJoinSecondBinding?= null
    private val binding : FragmentJoinSecondBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

//    private val customerViewModel : CustomerViewModel by activityViewModels()

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
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}