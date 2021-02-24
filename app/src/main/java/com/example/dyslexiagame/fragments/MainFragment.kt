package com.example.dyslexiagame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.dyslexiagame.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        letterButton.setOnClickListener {
            Navigation.findNavController(this.requireView())
                .navigate(R.id.action_mainFragment_to_lettersFragment)
        }
        colorsButton.setOnClickListener {
            Navigation.findNavController(this.requireView())
                .navigate(R.id.action_mainFragment_to_colorsFragment)
        }
        numbersButton.setOnClickListener {
            Navigation.findNavController(this.requireView())
                .navigate(R.id.action_mainFragment_to_numbersFragment)
        }
    }

}