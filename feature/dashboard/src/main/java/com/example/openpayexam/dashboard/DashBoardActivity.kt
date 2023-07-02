package com.example.openpayexam.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.openpayexam.dashboard.R
import com.example.openpayexam.dashboard.databinding.ActivityDashBoardBinding
import com.example.openpayexam.dashboard.status.MoviesTable
import com.example.openpayexam.dashboard.ui.home.view_model.HomeViewModel

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDashBoardBinding

    private val homeViewModel : HomeViewModel by viewModels()

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
        validateMovieList()

    }

    /** */
    private fun validateMovieList() {
        homeViewModel.validateTableData(this)
    }

    /** */
    private fun setUpView() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activity_dash_board_fcv)
        val navController = navHostFragment?.findNavController()

        navController?.let {
            binding.activityDashBoardBnv.setupWithNavController(it)

            binding.activityDashBoardBnv.setOnItemSelectedListener{ menuItem ->

                when(menuItem.itemId){
                    R.id.moviesFragment -> {



                        when(homeViewModel.moviesTableStatusLiveData.value){
                            MoviesTable.HAS_VALUES -> {
                                navController.navigate(menuItem.itemId)
                                true
                            }
                            else -> {
                                Toast.makeText(this,"Sin Info",Toast.LENGTH_SHORT).show()
                                false
                            }
                        }

                    }

                    else -> {
                        navController.navigate(menuItem.itemId)
                        true
                    }
                }

            }


        }?: run {
            Log.e("Error","Sorry")
        }

    }


}