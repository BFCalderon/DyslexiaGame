package com.example.dyslexiagame.adapter

import android.graphics.Color
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dyslexiagame.R
import com.example.dyslexiagame.interfaces.ProductActionInterface
import com.example.dyslexiagame.objects.LettersVO
import kotlinx.android.synthetic.main.product_item_layout.view.*

/**
 * Adaptador del recycler view que muestra la lista de productos
 * @author Brayan Calderon
 * @param productsList contiene la lista de los productos que van a ser mostrados
 * @param actionNotification instancia para notificar agregar al carrito y detalles
 */
class ProductsAdapter(
    var productsList: MutableList<LettersVO>,
    private val actionNotification: ProductActionInterface,
    private val letterInValidation: Char
): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.product_item_layout, parent, false))

    override fun getItemCount() = productsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val productName: TextView = itemView.textItem

        /**
         * Función que renderiza cada item del RecyclerView
         */
        fun bind(position: Int){
            this.productName.text = this@ProductsAdapter.productsList[position].letter.toString()
            this.productName.setOnClickListener {
                if(letterInValidation == productsList[position].letter){
                    actionNotification.iNotifySelection(true)
                    productsList[position].isSelected = true
                    this.productName.setBackgroundColor(Color.GREEN)
                    val existLetterUnselected = productsList.find { !it.isSelected && it.letter == letterInValidation} != null
                    if(!existLetterUnselected) {
                        actionNotification.iNotifyAllSelected()
                    }
                } else {
                    this.productName.setBackgroundColor(Color.RED)
                    actionNotification.iNotifySelection(false)
                    Handler().postDelayed({this.productName.setBackgroundColor(Color.WHITE)}, 1000)
                }
            }
        }
    }
}