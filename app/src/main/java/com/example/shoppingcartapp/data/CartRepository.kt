package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

class CartRepository(
     private val local: CartDataSource,
     private val remote: CartDataSource
) {

     fun getCartItems(): List<CartItem> = remote.getCartItems()

     fun addItem(item: CartItem) {
          local.addItem(item)
          remote.addItem(item)
     }

     fun removeItem(item: CartItem) {
          local.removeItem(item)
          remote.removeItem(item)
     }

}