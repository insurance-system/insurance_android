package com.insandroid.insurance.util

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.R
import com.insandroid.insurance.databinding.FragmentSplashBinding

class SplashFragment : Fragment(){
    private var _binding : FragmentSplashBinding?= null
    private val binding : FragmentSplashBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
            findNavController().navigate(R.id.action_fragment_splash_to_fragment_login)
        },2000)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}