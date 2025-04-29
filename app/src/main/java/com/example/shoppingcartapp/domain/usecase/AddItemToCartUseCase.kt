package com.example.shoppingcartapp.domain.usecase

import com.example.shoppingcartapp.domain.model.CartItem
import com.example.shoppingcartapp.data.repository.CartRepository

class AddItemToCartUseCase(private val repository: CartRepository) {
    suspend operator fun invoke(item: CartItem) {
        repository.addItem(item)
    }
}
