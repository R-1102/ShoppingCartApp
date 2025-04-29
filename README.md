#  Shopping Cart

This project is a simple Shopping Cart Android app implemented using the **MVI (Model-View-Intent)** architecture and **Clean Architecture** principles with Kotlin and Jetpack Compose.

##  Architecture Overview

The app is structured into three main layers:

- **Presentation Layer** – Jetpack Compose UI, ViewModel, State, and Intent.
- **Domain Layer** – Use cases and domain models.
- **Data Layer** – Repository pattern and in-memory data source.


## MVI Components

### Intent
```kotlin
sealed class CartIntent {
    object LoadCart : CartIntent()
    data class AddItem(val item: CartItem) : CartIntent()
    ...
}
```
### State
```
sealed class CartState {
    object Loading : CartState()
    data class Success(val items: List<CartItem>) : CartState()
    data class Error(val message: String) : CartState()
}
```
### Reducer (ViewModel)
```
fun handleIntent(intent: CartIntent) {
    when (intent) {
        is CartIntent.LoadCart -> ...
        is CartIntent.AddItem -> ...
    }
}
```
## Run the App
1. Clone the repo.

2. Open in Android Studio.
   
3. Run on emulator or device.
   
## Built With
- Kotlin
- Jetpack Compose
-  MVI
- Clean Architecture
