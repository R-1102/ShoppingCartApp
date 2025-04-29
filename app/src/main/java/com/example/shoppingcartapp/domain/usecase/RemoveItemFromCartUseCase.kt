package com.example.shoppingcartapp.domain.usecase

import com.example.shoppingcartapp.data.repository.CartRepository
import com.example.shoppingcartapp.domain.model.CartItem

class RemoveItemFromCartUseCase(private val repository: CartRepository) {
    suspend operator fun invoke(item: CartItem) {
        repository.removeItem(item)
    }
}
