package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class MenuFragment : Fragment() {

    private lateinit var aboutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view =  inflater.inflate(R.layout.fragment_menu, container, false)
        aboutButton = view.findViewById(R.id.aboutButton)

      val aboutFragment = AboutFragment()
        aboutButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container,aboutFragment)
                ?.commit()

        }


       return view
    }


}