package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.databinding.FragmentMineBinding
import com.insandroid.insurance.ui.adapter.customer.MyInsuranceAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsMoneyTestAdapter
import com.insandroid.insurance.ui.viewmodel.customer.CustomerViewModel
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.InsuranceApplication
import com.insandroid.insurance.util.MainActivity

//내 보험 화면
class MineFragment  : Fragment(){
    private var _binding : FragmentMineBinding?= null
    private val binding : FragmentMineBinding
        get() = _binding!!

    private lateinit var customerViewModel: CustomerViewModel

    private lateinit var myInsuranceAdapter : MyInsuranceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = InsuranceApplication.prefs.getString("name", "")

        binding.mineMyIns.text = "${name}님의 보험"

        val kindOfRole = InsuranceApplication.prefs.getString("kindOfRole", "")

        if(kindOfRole == "employee"){
            binding.workerEduGetRv.visibility = View.INVISIBLE
            binding.workerMineTv.visibility = View.VISIBLE
        }
        if(kindOfRole == "customer"){
            customerViewModel = (activity as MainActivity).customerViewModel

            customerViewModel.getMyInsurance(InsuranceApplication.prefs.getString("id", "").toLong())

            customerViewModel.myInsurance.observe(viewLifecycleOwner) {
                val result = it.data
                myInsuranceAdapter.submitList(result)
            }

            setUpRecyclerView()

            binding.workerEduGetRv.visibility = View.VISIBLE
            binding.workerMineTv.visibility = View.INVISIBLE

        }


    }

    private fun setUpRecyclerView(){
        myInsuranceAdapter = MyInsuranceAdapter()
        binding.workerEduGetRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = myInsuranceAdapter
        }

        myInsuranceAdapter.setOnItemClickListener {
            val action  = MineFragmentDirections.actionFragmentMineToFragmentCusInsMoney(it)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}