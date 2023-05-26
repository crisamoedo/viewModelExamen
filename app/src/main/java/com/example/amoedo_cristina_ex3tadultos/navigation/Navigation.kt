package com.example.amoedo_cristina_ex3tadultos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.amoedo_cristina_ex3tadultos.MenuScreen
import com.example.amoedo_cristina_ex3tadultos.listacontadores.ListaScreen
import com.example.amoedo_cristina_ex3tadultos.login.LoginScreen
import com.example.amoedo_cristina_ex3tadultos.contadores.Contadores

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route ){
        composable(route = Screens.MainScreen.route) { MenuScreen(navController) }

        composable(route = Screens.ListaCompra.route) { ListaScreen() }
        composable(route = Screens.Contadores.route) { Contadores() }
        composable(route = Screens.Login.route) { LoginScreen() }
    }

}




