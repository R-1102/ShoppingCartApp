package com.example.shoppingcartapp.data

import com.example.shoppingcartapp.domain.model.CartItem

class RemoteCartDataSource : CartDataSource {

    private val remoteItems = mutableListOf<CartItem>()

    init {
        // Mock preloaded remote items
        remoteItems.addAll(
            listOf(
                CartItem(1, "Shirt", 3, 150.0),
                CartItem(2, "Jeans", 5, 849.30),
                CartItem(3, "Cap", 2, 20.5)
            )
        )
    }

    override fun getCartItems(): List<CartItem> {
        return remoteItems
    }

    override fun addItem(item: CartItem) {
        for (i in remoteItems.indices) {
            if (remoteItems[i].id == item.id) {
                val updated = remoteItems[i].copy(quantity = remoteItems[i].quantity + 1)
                remoteItems[i] = updated
                return
            }
        }
        remoteItems.add(item.copy(quantity = 1))
    }

    override fun removeItem(item: CartItem) {
        for (i in remoteItems.indices) {
            if (remoteItems[i].id == item.id) {
                val current = remoteItems[i]
                if (current.quantity > 1) {
                    val updated = current.copy(quantity = current.quantity - 1)
                    remoteItems[i] = updated
                } else {
                    remoteItems.removeAt(i)
                }
                return
            }
        }
    }
}