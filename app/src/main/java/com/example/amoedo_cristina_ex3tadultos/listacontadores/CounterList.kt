package com.example.amoedo_cristina_ex3tadultos.listacontadores

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CountersList(
    list: List<Counter>,
    onIncrement: (Counter) -> Unit,
    onDecrement: (Counter) -> Unit,
    onRemoveItem: (Counter) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier.fillMaxSize()) {
        items(items = list,
            key = { it.id }) { element ->
            CounterListItem(
                name = element.name,
                count = element.count,
                onIncrement = { onIncrement(element) },
                onDecrement = { onDecrement(element) },
                onClose = { onRemoveItem(element) },
            )
        }
    }
}