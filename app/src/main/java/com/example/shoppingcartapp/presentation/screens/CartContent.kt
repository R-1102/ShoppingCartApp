package com.example.shoppingcartapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartContent(
    state: CartState,
    onIntent: (CartIntent) -> Unit
) {
    when (state) {
        is CartState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is CartState.Success -> {
            val items = state.items
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items) { item ->
                    Card(
                        Modifier.fillMaxWidth()
                    ) {
                        Column(
                            Modifier.padding(12.dp)
                        ) {
                            Text("${item.name} - \$${item.price}")
                            Text("Quantity: ${item.quantity}")

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Button(onClick = {
                                    onIntent(CartIntent.AddItem(item))
                                }) {
                                    Text("+")
                                }

                                Button(onClick = {
                                    onIntent(CartIntent.RemoveItem(item))
                                }) {
                                    Text("-")
                                }
                            }
                        }
                    }
                }
            }
        }

        is CartState.Error -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Error: ${(state).message}")
            }
        }
    }
}