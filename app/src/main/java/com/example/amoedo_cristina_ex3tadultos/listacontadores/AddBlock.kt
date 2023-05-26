package com.example.amoedo_cristina_ex3tadultos.listacontadores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amoedo_cristina_ex3tadultos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBlock(
    addCounter: (String) -> Unit,
    modifier: Modifier = Modifier,
    textButton: String = stringResource(R.string.add),
) {
    val focusManager = LocalFocusManager.current

    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text, onValueChange = { text = it }, Modifier.weight(1f)
        )
        Button(onClick = {
            if (text.isNotBlank()) addCounter(text)
            text = ""
            focusManager.clearFocus() // Esconde el teclado
        }) {
            Text(text = textButton)
        }
    }
}