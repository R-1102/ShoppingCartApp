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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "🛒 Shopping Cart",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        CartContent(state = state, onIntent = viewModel::handleIntent)

        Spacer(modifier = Modifier.height(24.dp))

    }
}

