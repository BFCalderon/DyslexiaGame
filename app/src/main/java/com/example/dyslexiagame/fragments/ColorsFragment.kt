package com.example.dyslexiagame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dyslexiagame.R

/**
 * @author Brayan Calderon
 * Fragmento que muestra los detalles de los productos
 */
class ColorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_colors_layout, container, false)
    }

}