package com.example.dyslexiagame.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dyslexiagame.R
import com.example.dyslexiagame.adapter.ProductsAdapter
import com.example.dyslexiagame.interfaces.ProductActionInterface
import com.example.dyslexiagame.objects.LettersVO
import kotlinx.android.synthetic.main.fragment_letters_layout.*
import java.util.*

/**
 * @author Brayan Calderon
 * Fragmento que contiene la información con los productos agregados
 */
class LettersFragment : Fragment() {

    private val lettersList = mutableListOf<LettersVO>()
    private var letterToValidate = listOf('p', 'd', 'q', 'b', 'f', 't', 'g')
    private var letterIndexInSelection = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_letters_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetLetters()
    }

    private fun Random.nextRandomLetter(range: IntRange): Int {
        return range.first + nextInt(range.last - range.first)
    }

    /**
     * Funcion que agrega los productos al RecyclerView
     */
    private fun initRecycler(listOfLetters: MutableList<LettersVO>) {
        val adapter = ProductsAdapter(listOfLetters,
            object : ProductActionInterface {
                override fun iNotifyAllSelected() {
                    letterIndexInSelection++
                    this@LettersFragment.view?.run {
                        setBackgroundColor(Color.GREEN)
                    }
                    Handler().postDelayed({
                        this@LettersFragment.view?.run {
                            setBackgroundColor(context.getColor(R.color.color_main_transparent))
                        }
                        resetLetters()}, 1000)
                }

                override fun iNotifySelection(isCorrect: Boolean) {
                    if(isCorrect){
                        score++
                    } else {
                        score--
                    }
                    scoreId.text = "$score"
                }

                override fun iNotifyDelete(productLocalId: Int, adapterPosition: Int) {
                }
            }, letterToValidate[letterIndexInSelection]
        )
        //this.adapterInstance = adapter
        lettersRecycler.adapter = adapter
        lettersRecycler.layoutManager = GridLayoutManager(context, 6)
    }

    /**
     * Funcion que genera las letras
     */
    private fun generateLetters(){
        lettersList.clear()// = mutableListOf()
        val charR = 'a'..'z'
        letterToValidate.forEach {
            lettersList.add(LettersVO(it))
            lettersList.add(LettersVO(it))
        }
        val random = Random()
        while (lettersList.size < 42){
            lettersList.add(LettersVO(random.nextRandomLetter(/*65..91*/97..122).toChar()))
        }
        lettersList.shuffle()
        lettersList.shuffle()
    }

    /**
     * genera y actualiza las letras en el recycler
     */
    private fun resetLetters(){
        if(letterIndexInSelection >= letterToValidate.size){
            letterIndexInSelection = 0
        }
        informationText.text = (context?.getString(R.string.select_letter)+" ${letterToValidate[letterIndexInSelection].toUpperCase()}")
        generateLetters()
        initRecycler(lettersList)
    }
}