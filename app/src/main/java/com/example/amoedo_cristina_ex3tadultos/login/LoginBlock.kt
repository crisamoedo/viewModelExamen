package com.example.amoedo_cristina_ex3tadultos.login

import android.util.Patterns
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBlock(
    logginError: Boolean,
    onLoggin: (String, String) -> Unit,
) {

    var emailString by rememberSaveable { mutableStateOf("") }  // (1)
    var passwordString by rememberSaveable { mutableStateOf("") }

    //si logginError es true mostramos el texto de error
    if (logginError)
        Text(
            text = "Email o contraseña inválidos",
            color = MaterialTheme.colorScheme.error
        )
    OutlinedTextField(
        value = emailString, onValueChange = { emailString = it.trim() },
        label = { Text(text = "Email") },
        isError = !emailString.isValidEmail() || logginError
    )
    OutlinedTextField(
        value = passwordString, onValueChange = { passwordString = it },
        label = { Text(text = "Contraseña") },
        isError = logginError,
        visualTransformation = PasswordVisualTransformation(), // Para mostrar puntos
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
    //escondemos el teclado cuando el usuario y contraseña son correcto
    if (emailString.isValidEmail() && passwordString.isValidPassword()){
        val focusManager = LocalFocusManager.current
        focusManager.clearFocus()
    }

    //activamos el botón de Login en caso de que email y contraseña sean válidos
    Button(
        onClick = { onLoggin(emailString, passwordString) },
        enabled = emailString.isValidEmail() && passwordString.isValidPassword(),

    ) {
        Text(text = "Log In")
    }

}

private const val MIN_SIZE_PASSWORD = 7
//aquí estamos usando funciones de extensión
//en el contexto en el que estoy String pasa a tener estos nuevos métodos
//se utiliza el this pq ya está haciendo referencia al objeto en el que estoy que es el String
fun String.isValidPassword() = this.length > MIN_SIZE_PASSWORD
fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()


