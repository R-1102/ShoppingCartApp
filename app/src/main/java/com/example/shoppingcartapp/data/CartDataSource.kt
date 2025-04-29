package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

class CartDataSource {
    private val cartItems = mutableListOf<CartItem>()

    fun getCartItems(): List<CartItem> = cartItems

    fun addItem(item: CartItem) {
        cartItems.add(item)
    }
    fun removeItem(item: CartItem) {
        cartItems.remove(item)
    }

}
