package com.example.dyslexiagame.interfaces

/**
 * @author Brayan Calderon
 * Interfaz mediante la cual se notifican acciones de agregar y detalles de los productos
 */
interface ProductActionInterface {
    fun iNotifyAllSelected()
    fun iNotifySelection(isCorrect: Boolean)
    fun iNotifyDelete(productLocalId: Int, adapterPosition: Int)
}