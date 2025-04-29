package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

class CartRepository(private val dataSource: CartDataSource) {

     fun getCartItems(): List<CartItem> = dataSource.getCartItems()
     fun addItem(item: CartItem) = dataSource.addItem(item)
     fun removeItem(item: CartItem) = dataSource.removeItem(item)
}
