package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

class CartDataSource {
    private val cartItems = mutableListOf<CartItem>(
        CartItem(id = 1, name = "Shirt", quantity = 1, price = 999.99),
        CartItem(id = 2, name = "Shoes", quantity = 2, price = 849.99),
        CartItem(id = 3, name = "Drees", quantity = 1, price = 799.99),
        CartItem(id = 4, name = "Cap", quantity = 1, price = 349.99),
    )

    fun getCartItems(): List<CartItem> = cartItems

    fun addItem(item: CartItem) {
        cartItems.add(item)
    }

    fun removeItem(item: CartItem) {
        cartItems.removeIf { it.id == item.id }
    }
}