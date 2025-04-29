package com.example.shoppingcartapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shoppingcartapp.presentation.viewModels.CartViewModel

@Composable
fun CartScreen(viewModel: CartViewModel) {
    val state by viewModel.state.collectAsState()

    when (state) {
        is CartState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is CartState.Success -> {
            val items = (state as CartState.Success).items
            LazyColumn {
                items(items) { item ->
                    Text(text = "${item.name} x${item.quantity} - \$${item.price}")
                }
            }
        }
        is CartState.Error -> {
            val message = (state as CartState.Error).message
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error: $message")
            }
        }
    }
}
