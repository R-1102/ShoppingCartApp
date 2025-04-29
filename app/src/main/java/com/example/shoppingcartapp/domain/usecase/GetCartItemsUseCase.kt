package com.example.shoppingcartapp.domain.usecase

import com.example.shoppingcartapp.domain.model.CartItem
import com.example.shoppingcartapp.data.repository.CartRepository

class GetCartItemsUseCase(private val repository: CartRepository) {
    suspend operator fun invoke(): List<CartItem> {
        return repository.getCartItems()
    }
}