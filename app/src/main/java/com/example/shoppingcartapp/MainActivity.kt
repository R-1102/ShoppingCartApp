package com.example.shoppingcartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shoppingcartapp.data.CartDataSource
import com.example.shoppingcartapp.data.repository.CartRepository
import com.example.shoppingcartapp.domain.usecase.AddItemToCartUseCase
import com.example.shoppingcartapp.domain.usecase.GetCartItemsUseCase
import com.example.shoppingcartapp.domain.usecase.RemoveItemFromCartUseCase
import com.example.shoppingcartapp.presentation.screens.CartScreen
import com.example.shoppingcartapp.presentation.viewModels.CartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataSource = CartDataSource()
        val repository = CartRepository(dataSource)
        val getCartItemsUseCase = GetCartItemsUseCase(repository)
        val addItemToCartUseCase = AddItemToCartUseCase(repository)
        val removeItemFromCartUseCase = RemoveItemFromCartUseCase(repository)

        val viewModel = CartViewModel(getCartItemsUseCase, addItemToCartUseCase,removeItemFromCartUseCase)

        setContent {
            CartScreen(viewModel = viewModel)
        }
    }
}