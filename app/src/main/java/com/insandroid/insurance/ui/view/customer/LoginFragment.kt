package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){
    private var _binding : FragmentLoginBinding?= null
    private val binding : FragmentLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //로그인 버튼
        binding.signInLoginBt.setOnClickListener {
            val action = LoginFragmentDirections.actionFragmentLoginToFragmentHome()
            findNavController().navigate(action)
        }

        //회원가입 버튼
        binding.loginToJoinTv.setOnClickListener {
            val action = LoginFragmentDirections.actionFragmentLoginToFragmentJoinFirst()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}