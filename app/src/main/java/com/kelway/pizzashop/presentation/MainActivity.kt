package com.kelway.pizzashop.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.pizzashop.R
import com.kelway.pizzashop.databinding.ActivityMainBinding
import com.kelway.pizzashop.utils.showToast

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        activateBottomNavigateMenu()
    }

    private fun activateBottomNavigateMenu() {
        binding.bottomNavigation.setOnItemSelectedListener { itemMenu ->
            when (itemMenu.itemId) {
                R.id.pageMenu -> findNavController(R.id.navHostFragment).navigate(R.id.menuFragment)
                R.id.pageProfile -> findNavController(R.id.navHostFragment).navigate(R.id.profileFragment)
                R.id.pageBasket -> findNavController(R.id.navHostFragment).navigate(R.id.basketFragment)
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.qrCode -> showToast(getString(R.string.message_no_access))
        }
        return super.onOptionsItemSelected(item)
    }

}