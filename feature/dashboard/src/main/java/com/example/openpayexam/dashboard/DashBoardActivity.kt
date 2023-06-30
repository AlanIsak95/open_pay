package com.example.openpayexam.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.openpayexam.dashboard.R
import com.example.openpayexam.dashboard.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDashBoardBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()

    }

    /** */
    private fun setUpView() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activity_dash_board_fcv)
        val navController = navHostFragment?.findNavController()

        navController?.let {
            binding.activityDashBoardBnv.setupWithNavController(it)
        }?: run {
            Log.e("Error","Sorry")
        }

    }


}