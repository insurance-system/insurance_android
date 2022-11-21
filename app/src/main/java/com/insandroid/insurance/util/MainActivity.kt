package com.insandroid.insurance.util

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.insandroid.insurance.R
import com.insandroid.insurance.databinding.ActivityMainBinding
import com.insandroid.insurance.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //네비게이션들을 담는 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.home_fragment_view) as NavHostFragment

        //네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션 뷰와 네비게이션을 묶어준다.
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

//        바텀 네비게이션 출력하는 부분과 그렇지 않은 부분을 나눔
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.fragment_home || destination.id == R.id.fragment_mine
                || destination.id == R.id.fragment_setting) {
                binding.bottomNavigationView.visibility = View.VISIBLE
                binding.homeFragmentView.setPadding(0,0,0,0)}
            else {
                binding.bottomNavigationView.visibility= View.GONE
                binding.homeFragmentView.setPadding(0,0,0,0)
            }
        }

    }

}