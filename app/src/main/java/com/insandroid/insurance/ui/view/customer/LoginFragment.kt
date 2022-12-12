package com.insandroid.insurance.ui.view.customer

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insandroid.insurance.R
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import com.insandroid.insurance.data.model.customer.PostLogin
import com.insandroid.insurance.data.model.customer.PostLoginResponse
import com.insandroid.insurance.databinding.FragmentLoginBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment(){
    private var _binding : FragmentLoginBinding?= null
    private val binding : FragmentLoginBinding
        get() = _binding!!

    private var kind : String = ""

    private lateinit var customerViewModel: CustomerViewModel

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

        customerViewModel = (activity as MainActivity).customerViewModel

        binding.loginKindOfRg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.login_customer -> kind = "customer"
                R.id.login_worker -> kind = "worker"
            }
        }

        //로그인 버튼
        binding.signInLoginBt.setOnClickListener {
            if(binding.loginIdEt.text.toString() == ""
                || binding.signInPwEt.text.toString() == ""
                || kind == ""
            ){
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else{
                val postLogin = PostLogin(
                    email = binding.loginIdEt.text.toString(),
                    password = binding.signInPwEt.text.toString()
                )
                if(kind == "customer"){
                    val call: Call<PostLoginResponse> = customerViewModel.postLogin(postLogin)

                    call.enqueue(object: Callback<PostLoginResponse> {
                        override fun onResponse(
                            call: Call<PostLoginResponse>,
                            responseName: Response<PostLoginResponse>
                        ) {
                            if(responseName.isSuccessful){
                                if(responseName.body()?.errorCode == "C0001"){
                                    binding.loginNoSuccess.visibility = View.VISIBLE
                                }else{
                                    binding.loginNoSuccess.visibility = View.INVISIBLE
                                    InsuranceApplication.prefs.setString("id", responseName.body()?.data?.id.toString())
                                    InsuranceApplication.prefs.setString("name", responseName.body()?.data?.name.toString())
                                    InsuranceApplication.prefs.setString("kindOfRole", responseName.body()?.data?.kindOfRole.toString())

                                    InsuranceApplication.prefs.setUserId(binding.loginIdEt.text.toString())
                                    InsuranceApplication.prefs.setUserPW(binding.signInPwEt.text.toString())
                                    Toast.makeText(requireContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                                    val handler = Handler(Looper.getMainLooper())

                                    handler.postDelayed({
                                        findNavController().navigate(R.id.action_fragment_login_to_fragment_home)
                                    },1000)
                                }

                            }
                        }
                        override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                            Log.e("idcheck_server_test", "fail")
                        }
                    })
                }
                if(kind == "worker"){ //E0001
                    val call: Call<PostLoginResponse> = customerViewModel.postEmployeeLogin(postLogin)

                    call.enqueue(object: Callback<PostLoginResponse> {
                        override fun onResponse(
                            call: Call<PostLoginResponse>,
                            responseName: Response<PostLoginResponse>
                        ) {
                            if(responseName.isSuccessful){
                                if(responseName.body()?.errorCode == "E0001"){
                                    binding.loginNoSuccess.visibility = View.VISIBLE
                                }else{
                                    binding.loginNoSuccess.visibility = View.INVISIBLE

                                    InsuranceApplication.prefs.setString("id", responseName.body()?.data?.id.toString())
                                    InsuranceApplication.prefs.setString("name", responseName.body()?.data?.name.toString())
                                    InsuranceApplication.prefs.setString("kindOfRole", responseName.body()?.data?.kindOfRole.toString())

                                    InsuranceApplication.prefs.setUserId(binding.loginIdEt.text.toString())
                                    InsuranceApplication.prefs.setUserPW(binding.signInPwEt.text.toString())

                                    Toast.makeText(requireContext(), "관리자 계정으로 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                                    val handler = Handler(Looper.getMainLooper())

                                    handler.postDelayed({
                                        findNavController().navigate(R.id.action_fragment_login_to_fragment_home)
                                    },1000)
                                }

                            }
                        }
                        override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                            Log.e("idcheck_server_test", "fail")
                        }
                    })
                }

            }
        }

        //회원가입 버튼
        binding.loginToJoinTv.setOnClickListener {
            val action = LoginFragmentDirections.actionFragmentLoginToFragmentJoinThird()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}