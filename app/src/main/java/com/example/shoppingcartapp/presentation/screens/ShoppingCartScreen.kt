package com.example.shoppingcartapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppingcartapp.domain.model.CartItem
import com.example.shoppingcartapp.presentation.viewModels.CartViewModel

@Composable
fun CartScreen(viewModel: CartViewModel) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.handleIntent(CartIntent.LoadCart)
    }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "🛒 Shopping Cart", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        CartContent(viewModel, state)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CartContent(viewModel: CartViewModel, state: CartState) {
    when (state) {
        is CartState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is CartState.Success -> {
            val items = state.items
            if (items.isEmpty()) {
                Text("Cart is empty.")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(items) { item ->
                        Card(Modifier.fillMaxWidth().padding(4.dp)) {
                            Column(Modifier.padding(8.dp)) {
                                Text("${item.name} - \$${item.price}")
                                Text("Quantity: ${item.quantity}")

                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                                    Button(onClick = {
                                        viewModel.handleIntent(CartIntent.RemoveItem(item))
                                    }) {
                                        Text("Remove")
                                    }
                                }
                            }
                        }
                    }
                }
                Button(
                    onClick = {
                        val newItem = CartItem(
                            id = 6, // make sure it's unique
                            name = "Wireless Mouse",
                            quantity = 1,
                            price = 29.99
                        )
                        viewModel.handleIntent(CartIntent.AddItem(newItem))
                    }
                ) {
                    Text("Add Item")
                }
            }
        }

        is CartState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: ${(state as CartState.Error).message}")
            }
        }
    }
}

