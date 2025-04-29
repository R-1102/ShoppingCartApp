package com.example.shoppingcartapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingcartapp.domain.model.CartItem
import com.example.shoppingcartapp.domain.usecase.AddItemToCartUseCase
import com.example.shoppingcartapp.domain.usecase.GetCartItemsUseCase
import com.example.shoppingcartapp.domain.usecase.RemoveItemFromCartUseCase
import com.example.shoppingcartapp.presentation.screens.CartIntent
import com.example.shoppingcartapp.presentation.screens.CartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val addItemToCartUseCase: AddItemToCartUseCase,
    private val removeItemFromCartUseCase: RemoveItemFromCartUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CartState>(CartState.Loading)
    val state: StateFlow<CartState> get() = _state

    fun handleIntent(intent: CartIntent) {
        when (intent) {
            is CartIntent.LoadCart -> {
                loadCartItems()
            }

            is CartIntent.AddItem -> {
                addItemToCart(intent.item)
            }

            is CartIntent.RemoveItem -> {
                removeItemFromCart(intent.item)
            }
        }
    }

    private fun loadCartItems() {
        viewModelScope.launch {
            _state.value = CartState.Loading
            try {
                val items = getCartItemsUseCase()
                _state.value = CartState.Success(items)
            } catch (e: Exception) {
                _state.value = CartState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    private fun addItemToCart(item: CartItem) {
        viewModelScope.launch {
            try {
                addItemToCartUseCase(item)
                loadCartItems() // Refresh
            } catch (e: Exception) {
                _state.value = CartState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    private fun removeItemFromCart(item: CartItem) {
        viewModelScope.launch {
            try {
                removeItemFromCartUseCase(item)
                loadCartItems()
            } catch (e: Exception) {
                _state.value = CartState.Error(e.message ?: "Unknown Error")
            }
        }

    }
}


