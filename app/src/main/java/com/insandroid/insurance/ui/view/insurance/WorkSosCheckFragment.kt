package com.insandroid.insurance.ui.view.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.insandroid.insurance.data.model.insurance.IncidentGet
import com.insandroid.insurance.databinding.FragmentWorkNewCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkNotCustomerBinding
import com.insandroid.insurance.databinding.FragmentWorkSosCheckBinding
import com.insandroid.insurance.ui.adapter.insurance.IncidentGetAdapter
import com.insandroid.insurance.ui.adapter.insurance.InsMoneyTestAdapter
import com.insandroid.insurance.ui.viewmodel.insurance.MainViewModel
import com.insandroid.insurance.util.MainActivity

//사고 발생 신고 접수확인 뷰
class WorkSosCheckFragment: Fragment(){
    private var _binding : FragmentWorkSosCheckBinding?= null
    private val binding : FragmentWorkSosCheckBinding
        get() = _binding!!

    private lateinit var mainViewModel: MainViewModel

    private lateinit var incidentGetAdapter: IncidentGetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkSosCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = (activity as MainActivity).mainViewModel

        mainViewModel.getIncident(1)

        mainViewModel.getIncident.observe(viewLifecycleOwner) {
            val result = it.data
            incidentGetAdapter.submitList(result)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        incidentGetAdapter = IncidentGetAdapter()
        binding.workerSosCheckRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = incidentGetAdapter
        }

        incidentGetAdapter.setOnItemClickListener {
            val action  = WorkSosCheckFragmentDirections.actionFragmentWorkSosCheckToFragmentWorkSosDo(it)
            findNavController().navigate(action)
            println("gg")
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}