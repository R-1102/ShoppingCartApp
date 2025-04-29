package com.example.shoppingcartapp.domain.usecase

import com.example.shoppingcartapp.domain.model.CartItem
import com.example.shoppingcartapp.data.CartRepository

class GetCartItemsUseCase(private val repository: CartRepository) {
     operator fun invoke(): List<CartItem> {
        return repository.getCartItems()
    }
}