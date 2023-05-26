package com.example.amoedo_cristina_ex3tadultos.navigation

sealed class Screens (val route: String){

    object MainScreen: Screens("initial_screen")
    object ListaCompra: Screens("Lista Compra")
    object Contadores: Screens("Contadores")
    object Login: Screens("Login")
}