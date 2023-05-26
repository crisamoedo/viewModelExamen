package com.example.amoedo_cristina_ex3tadultos.contadores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.amoedo_cristina_ex3tadultos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowBlock(onUpdateNumCounters: (Int) -> Unit, modifier: Modifier = Modifier) {

    val focusManager = LocalFocusManager.current

    var text by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(10.dp)
    ) {

        OutlinedTextField(
            value = text, onValueChange = { text = it },
            label = { Text(text = stringResource(R.string.num_counters)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        Button(
            onClick = {
                if (text.isNotBlank()) onUpdateNumCounters(text.toIntOrNull() ?: 0)
                text = ""
                focusManager.clearFocus() // Esconde el teclado
            },
        ) { Text(text = stringResource(R.string.show)) }
    }
}