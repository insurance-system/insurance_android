package com.insandroid.insurance.ui.adapter.customer

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.insandroid.insurance.ui.view.customer.CusLifeInsFragment
import com.insandroid.insurance.ui.view.customer.CusUnlifeInsFragment

//생명, 비생명 보험 출력하기 뷰
class AccountFindVPAdapter (fragment : Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CusLifeInsFragment()
            else -> CusUnlifeInsFragment()
        }
    }
}