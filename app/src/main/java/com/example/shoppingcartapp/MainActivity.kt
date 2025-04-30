package com.example.shoppingcartapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shoppingcartapp.data.CartDataSource
import com.example.shoppingcartapp.data.CartRepository
import com.example.shoppingcartapp.data.LocalCartDataSource
import com.example.shoppingcartapp.data.RemoteCartDataSource
import com.example.shoppingcartapp.domain.usecase.AddItemToCartUseCase
import com.example.shoppingcartapp.domain.usecase.GetCartItemsUseCase
import com.example.shoppingcartapp.domain.usecase.RemoveItemFromCartUseCase
import com.example.shoppingcartapp.presentation.screens.CartScreen
import com.example.shoppingcartapp.presentation.viewModels.CartViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val localDataSource = LocalCartDataSource()
        val remoteDataSource = RemoteCartDataSource()
        val repository = CartRepository(localDataSource, remoteDataSource)

        val getCartItemsUseCase = GetCartItemsUseCase(repository)
        val addItemToCartUseCase = AddItemToCartUseCase(repository)
        val removeItemFromCartUseCase = RemoveItemFromCartUseCase(repository)

        val viewModel = CartViewModel(
            getCartItemsUseCase,
            addItemToCartUseCase,
            removeItemFromCartUseCase
        )
        setContent {
            CartScreen(viewModel = viewModel)
        }
    }
}