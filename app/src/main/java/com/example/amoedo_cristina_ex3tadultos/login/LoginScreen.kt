package com.example.amoedo_cristina_ex3tadultos.login


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amoedo_cristina_ex3tadultos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    val vm: LoginViewModel = viewModel()

    Scaffold(
        floatingActionButton =

        { vm.loggedUser?.let { WriteFAB()} },

        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Volver atrás")
                    }
                },
                title = {
                    Text(
                        //cuando el loggedUser es null pone Login, sino pone el nombre del usuario en el scaffold
                        text = vm.loggedUser?.name ?: stringResource(R.string.login)
                    )
                },

                actions = {
                    vm.loggedUser?.let {
                        //este button solo se va a ver cuando loggedUser no es null, cuando estamos loggeados
                        //aquí cuando hacemos click en el button vamos a llamar a la función logout, ha sucedido un evento en la vista
                        //sucedió un evento en la ui, lo subimos al estado, llamamos al viewmodel a un método que dentro lo que hace es modificar el estado
                        //que determina lo que estamos viendo
                        //todos los sitios donde está esa variable mutable (_loggedUser) se recomponen
                        Button(onClick = { vm.logOut() }) {
                            Text(text = stringResource(R.string.log_out))
                        }
                    }?: Iconos()



                }
            )
        }) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            //aquí lo que hacemos es que si el usuario está loggeado mostramos el texto de acceso correcto y el AlertDialaog de guardar datos
            vm.loggedUser?.let {

                Column(
                    Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(70.dp)
                ) {
                    Text(text = stringResource(R.string.acceso_correcto))

                    AlertDialog()
                }

                //si es null llamamos a loginblock que recibe la información y en base a eso muestra el error en rojo
            } ?: LoginBlock(
                logginError = vm.logginError,
                onLoggin = { email, password -> vm.loggin(email, password) },
            )


        }

    }


}

@Composable
fun WriteFAB() {
    ExtendedFloatingActionButton(
        text = { Text("Correo Nuevo") },
        onClick = { TODO() },

        icon = {
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = "Redactar"
            )
        })
}

@Composable
fun NoteFAB() {
    FloatingActionButton(onClick = { TODO() }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Añadir"
        )
    }
}

@Composable
fun SaveFAB() {
    ExtendedFloatingActionButton(
        text = {
            Text("GUARDAR")
        },
        icon = {
            Icon(
                painter = painterResource(R.drawable.save),
                contentDescription = "Guardar cambios"
            )
        },
        onClick = { }
    )
}

@Composable
fun AlertDialog() {
    MaterialTheme {
        Column {
            var openDialog by rememberSaveable { mutableStateOf(false) }

            Button(onClick = {
                openDialog = true
            }) {
                Text("Guardar")
            }

            if (openDialog) {

                AlertDialog(
                    onDismissRequest = { openDialog = false },
                    title = {
                        Text(text = "Guardar usuario y contraseña")
                    },
                    text = { Text("") },
                    confirmButton = {
                        Button(
                            onClick = {
                                openDialog = false
                            }) { Text("Cancelar") }
                    },
                    dismissButton = {
                        Button(
                            onClick = { openDialog = false }) {
                            Text("Guardar")
                        } })
            } } } }
@Composable
fun Iconos(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refrescar")
    }
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir")
    }
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
    }
}