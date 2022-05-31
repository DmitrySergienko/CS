package com.example.cs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cs.R
import com.example.cs.databinding.ActivityMainBinding
import com.example.cs.ui.repo.RepoFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }


    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.bottom_git -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, RepoFragment()).commit()
                    true
                }
                else -> true
            }
        }
        //default view
        binding.bottomNavigationView.selectedItemId = R.id.bottom_git
    }
}

