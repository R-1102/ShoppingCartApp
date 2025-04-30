package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

interface CartDataSource {
    fun getCartItems(): List<CartItem>
    fun addItem(item: CartItem)
    fun removeItem(item: CartItem)
}