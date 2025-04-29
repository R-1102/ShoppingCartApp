package com.example.shoppingcartapp.presentation.screens
import com.example.shoppingcartapp.domain.model.CartItem

sealed class CartState {
    object Loading : CartState()
    data class Success(val items: List<CartItem>) : CartState()
    data class Error(val message: String) : CartState()
}