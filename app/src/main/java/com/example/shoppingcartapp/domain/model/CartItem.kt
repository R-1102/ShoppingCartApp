package com.example.shoppingcartapp.domain.model

data class CartItem (
    val id: Int,
    val name: String,
    val price: Double,
    val quantity:Int
)