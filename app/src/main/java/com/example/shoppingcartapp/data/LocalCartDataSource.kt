package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

class LocalCartDataSource : CartDataSource {
    private val cartItems = mutableListOf<CartItem>()

    override fun getCartItems(): List<CartItem> = cartItems

    override fun addItem(item: CartItem) {
        for (i in cartItems.indices) {
            if (cartItems[i].id == item.id) {
                val updated = cartItems[i].copy(quantity = cartItems[i].quantity + 1)
                cartItems[i] = updated
                return
            }
        }
        cartItems.add(item.copy(quantity = 1))
    }

    override fun removeItem(item: CartItem) {
        for (i in cartItems.indices) {
            if (cartItems[i].id == item.id) {
                val current = cartItems[i]
                if (current.quantity > 1) {
                    val updated = current.copy(quantity = current.quantity - 1)
                    cartItems[i] = updated
                } else {
                    cartItems.removeAt(i)
                }
                return
            }
        }
    }
}