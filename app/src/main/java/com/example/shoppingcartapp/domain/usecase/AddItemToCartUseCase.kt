package com.example.shoppingcartapp.domain.usecase

import com.example.shoppingcartapp.domain.model.CartItem
import com.example.shoppingcartapp.data.CartRepository

class AddItemToCartUseCase(private val repository: CartRepository) {
     operator fun invoke(item: CartItem) {
        repository.addItem(item)
    }
}
