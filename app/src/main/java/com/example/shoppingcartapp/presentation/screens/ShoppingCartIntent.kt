package com.example.shoppingcartapp.presentation.screens

import com.example.shoppingcartapp.domain.model.CartItem

sealed class CartIntent {
    object LoadCart : CartIntent()
    data class AddItem(val item: CartItem) : CartIntent()
    data class RemoveItem(val item: CartItem) : CartIntent()
    
}
