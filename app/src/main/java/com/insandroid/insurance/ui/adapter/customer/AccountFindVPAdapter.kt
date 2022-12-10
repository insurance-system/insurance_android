package com.insandroid.insurance.ui.adapter.customer

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.insandroid.insurance.ui.view.customer.CusLifeInsFragment
import com.insandroid.insurance.ui.view.customer.CusUnlifeInsFragment

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