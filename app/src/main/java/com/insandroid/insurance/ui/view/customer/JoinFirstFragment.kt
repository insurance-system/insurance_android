package com.insandroid.insurance.ui.view.customer

import android.graphics.Color
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
import com.insandroid.insurance.data.model.customer.JoinDataRequest
import com.insandroid.insurance.data.model.customer.JoinDataResponse
import com.insandroid.insurance.databinding.FragmentJoinFirstBinding
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.util.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinFirstFragment  : Fragment(){
    private var _binding : FragmentJoinFirstBinding?= null
    private val binding : FragmentJoinFirstBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJoinFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customerViewModel = (activity as MainActivity).customerViewModel

        binding.bt.setOnClickListener {
            if( binding.firstEmail.text.toString() == ""
                || binding.firstPassword.text.toString() == ""
                || binding.firstName.text.toString() == ""
                || binding.firstAddress.text.toString() == ""
                || binding.firstDetailAddress.text.toString() == ""
                || binding.firstZipcode.text.toString() == ""
                || binding.secondSsn.text.toString() == ""
                || binding.secondPhone.text.toString() == ""
            ) {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }else {
//                customerViewModel.updateEmail(binding.firstEmail.text.toString())
//                customerViewModel.updateInputPw(binding.firstPassword.text.toString())
//                customerViewModel.updateInputName(binding.firstName.text.toString())
//                customerViewModel.updateInputAddress(binding.firstAddress.text.toString())
//                customerViewModel.updateDetailAddress(binding.firstDetailAddress.text.toString())
//                customerViewModel.updateZipcode(binding.firstZipcode.text.toString())
//                customerViewModel.updatePhoneNum(binding.secondPhone.text.toString())
//                customerViewModel.updateSsn(binding.secondSsn.text.toString())

                val joinDataRequest = JoinDataRequest(
                    password = binding.firstPassword.text.toString(),
                    name = binding.firstName.text.toString(),
                    address = binding.firstAddress.text.toString(),
                    detailAddress = binding.firstDetailAddress.text.toString(),
                    zipcode = binding.firstZipcode.text.toString(),
                    email = binding.firstEmail.text.toString(),
                    phoneNumber = binding.secondPhone.text.toString(),
                    kindOfJob = customerViewModel.job.value,
                    kindOfInsurance = customerViewModel.insurance.value,
                    ssn = binding.secondSsn.text.toString(),
                    cancer = customerViewModel.cancer.value,
                    smoke = customerViewModel.smoke.value,
                    alcohol = customerViewModel.drink.value
                )

//                customerViewModel.customerJoin(joinDataRequest)
                val call: Call<JoinDataResponse> = customerViewModel.customerJoin(joinDataRequest)

                call.enqueue(object: Callback<JoinDataResponse> {
                    override fun onResponse(
                        call: Call<JoinDataResponse>,
                        responseName: Response<JoinDataResponse>
                    ) {//이메일형식, 이메일중복, 핸드폰번호형식, 비밀번호형식, 주민번호 형식
                        if(responseName.isSuccessful){
                            if(responseName.body()?.errorCode == "C1000"){
                                Toast.makeText(requireContext(), responseName.body()?.message, Toast.LENGTH_SHORT).show()
                            }else if(responseName.body()?.errorCode == "C0002"){
                                Toast.makeText(requireContext(), responseName.body()?.message, Toast.LENGTH_SHORT).show()
                            }
                            else if(responseName.body()?.errorCode == "C1001"){
                                Toast.makeText(requireContext(), responseName.body()?.message, Toast.LENGTH_SHORT).show()
                            }else if(responseName.body()?.errorCode == "C1004"){
                                Toast.makeText(requireContext(), responseName.body()?.message, Toast.LENGTH_SHORT).show()
                            }else if(responseName.body()?.errorCode == "C1002"){
                                Toast.makeText(requireContext(), responseName.body()?.message, Toast.LENGTH_SHORT).show()
                            }else {
                                Toast.makeText(requireContext(), "회원가입을 완료하였습니다.", Toast.LENGTH_SHORT)
                                    .show()
                                val handler = Handler(Looper.getMainLooper())

                                handler.postDelayed({
                                    findNavController().navigate(R.id.action_fragment_join_first_to_fragment_login)
                                }, 1000)
                            }
                        }
                    }

                    override fun onFailure(call: Call<JoinDataResponse>, t: Throwable) {
                        Log.e("idcheck_server_test", "fail")
                    }
                })

//                if(customerViewModel.resultJoin.value!!.errorCode == "C1000"){
//                    Toast.makeText(requireContext(), customerViewModel.resultJoin.value!!.message, Toast.LENGTH_SHORT).show()
//                }else if(customerViewModel.resultJoin.value!!.errorCode == "C0002"){
//                    Toast.makeText(requireContext(), customerViewModel.resultJoin.value!!.message, Toast.LENGTH_SHORT).show()
//                }
//                else if(customerViewModel.resultJoin.value!!.errorCode == "C1001"){
//                    Toast.makeText(requireContext(), customerViewModel.resultJoin.value!!.message, Toast.LENGTH_SHORT).show()
//                }else if(customerViewModel.resultJoin.value!!.errorCode == "C1004"){
//                    Toast.makeText(requireContext(), customerViewModel.resultJoin.value!!.message, Toast.LENGTH_SHORT).show()
//                }else {
//                    customerViewModel.resultJoin.observe(viewLifecycleOwner) {
//                        //이메일형식, 이메일중복, 핸드폰번호형식, 비밀번호형식
//                        Toast.makeText(requireContext(), "회원가입을 완료하였습니다.", Toast.LENGTH_SHORT)
//                            .show()
//                        val handler = Handler(Looper.getMainLooper())
//
//                        handler.postDelayed({
//                            findNavController().navigate(R.id.action_fragment_join_first_to_fragment_login)
//                        }, 1000)
//                    }
//                }

            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}