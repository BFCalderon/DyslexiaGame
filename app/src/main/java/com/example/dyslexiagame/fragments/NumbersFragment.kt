package com.example.dyslexiagame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dyslexiagame.R

/**
 * @author Brayan Calderon
 * Fragmento mediante el cual se listan los productos
 */
class NumbersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_numbers_layout, container, false)
    }

}