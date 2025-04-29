package com.example.shoppingcartapp.domain.usecase

import com.example.shoppingcartapp.data.CartRepository
import com.example.shoppingcartapp.domain.model.CartItem

class RemoveItemFromCartUseCase(private val repository: CartRepository) {
     operator fun invoke(item: CartItem) {
        repository.removeItem(item)
    }
}
