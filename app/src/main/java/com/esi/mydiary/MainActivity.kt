package com.esi.mydiary

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.esi.mydiary.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        navController = this.findNavController(R.id.host_fragment)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupWithNavController(binding.toolbar,navController)

    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
