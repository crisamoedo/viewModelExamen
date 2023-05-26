package com.example.amoedo_cristina_ex3tadultos.contadores

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amoedo_cristina_ex3tadultos.R

@Composable
fun CounterBlock(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Button(
            onClick = onIncrement,
        ) {
            Text(text = stringResource(id = R.string.incrementar))
        }
        Text(text = "$count", modifier = Modifier.padding(20.dp))
        Button(
            onClick = onDecrement,
            enabled = count > 0,
        ) {
            Text(text = stringResource(id = R.string.decrementar))
        }

    }
}