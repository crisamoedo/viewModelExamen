package com.example.amoedo_cristina_ex3tadultos.listacontadores

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amoedo_cristina_ex3tadultos.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaScreen() {
    val viewModel: CountersListViewModel = viewModel()

    val context = LocalContext.current

    Scaffold(

        floatingActionButton = { AddFAB() },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.title)
                    )
                },
                actions = {
                    Text(
                        text = stringResource(R.string.cesta, viewModel.getGlobalCount())
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.shopping),
                            contentDescription = "Compra"
                        )
                    }
                },

                )


        },
    ) { paddingValues ->

        Column(
            Modifier.padding(paddingValues)
        ) {
            AddBlock(addCounter = {
                if (!viewModel.add(it))
                    Toast.makeText(context, "Ya existe ese producto", Toast.LENGTH_SHORT).show()
            })
            CountersList(
                list = viewModel.list,
                onIncrement = { viewModel.increment(it) },
                onDecrement = { viewModel.decrement(it) },
                onRemoveItem = { viewModel.remove(it) },
            )

        }

    }
}

@Composable
fun AddFAB() {
    FloatingActionButton(onClick = { TODO() }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Añadir"
        )
    }
}