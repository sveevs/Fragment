package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var bottonMenu: BottomNavigationView

private const val LAST_SELECTED_ITEM="item"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottonMenu = findViewById(R.id.bottom_menu)

        bottonMenu.setOnItemSelectedListener { item->
        when (item.itemId)
        {
        R.id.menu -> {
            val menuFragment = MenuFragment()
            replaceFragment(menuFragment)
            /*supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit()*/
        }

            R.id.about ->
            {
                val aboutFragment = AboutFragment()
                replaceFragment(aboutFragment)
                /*supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container,aboutFragment)
                    .commit()*/
            }

            R.id.radio_button ->
            {
                val radioFragment = RadioFragment()
                replaceFragment(radioFragment)
                /*supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container,aboutFragment)
                    .commit()*/
            }

        }

            true
        }

        bottonMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.menu

       /* val menuFragment = MenuFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,menuFragment)
            .commit()*/
    }

    private fun replaceFragment(fragment: Fragment)
    {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle ) {
        outState.putInt(LAST_SELECTED_ITEM, bottonMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }

}