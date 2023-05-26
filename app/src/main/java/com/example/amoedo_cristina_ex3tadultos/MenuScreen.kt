package com.example.amoedo_cristina_ex3tadultos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.amoedo_cristina_ex3tadultos.navigation.Screens


@Composable
 fun MenuScreen(navController: NavController) {

 Column(
  modifier = Modifier
   .fillMaxSize()
   .verticalScroll(rememberScrollState()),
  verticalArrangement = Arrangement.Center,
  horizontalAlignment = Alignment.CenterHorizontally,

  ){
  Button(onClick = { navController.navigate(route = Screens.ListaCompra.route) }) {
   Text(text = "Lista compra")

  }

  Button(onClick = { navController.navigate(route = Screens.Contadores.route) }) {
   Text(text = "Contadores")

  }

  Button(onClick = { navController.navigate(route = Screens.Login.route) }) {
   Text(text = "Login Usuario")

  }
 }


}