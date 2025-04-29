package com.example.shoppingcartapp.data.repository

import com.example.shoppingcartapp.data.CartDataSource
import com.example.shoppingcartapp.domain.model.CartItem

class CartRepository(private val dataSource: CartDataSource) {

    suspend fun getCartItems(): List<CartItem> = dataSource.getCartItems()
    suspend fun addItem(item: CartItem) = dataSource.addItem(item)
    suspend fun removeItem(item: CartItem) = dataSource.removeItem(item)
}
