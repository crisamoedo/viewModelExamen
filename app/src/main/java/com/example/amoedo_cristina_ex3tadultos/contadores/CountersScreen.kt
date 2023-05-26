package com.example.amoedo_cristina_ex3tadultos.contadores

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amoedo_cristina_ex3tadultos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contadores() {
    val viewModel: CountersListViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.contadores)) },
                actions = {
                    if (viewModel.isShowingCounters()) {
                        IconButton(onClick = { viewModel.restart() }) {
                            Icon(
                                imageVector = Icons.Filled.Refresh,
                                contentDescription = "Volver atrás"
                            )
                        }
                    }
                })
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(15.dp)
        ) {

            if (!viewModel.isShowingCounters()) {
                ShowBlock( onUpdateNumCounters = { viewModel.setSize(it) } )
            } else {
                CountersList(
                    list = viewModel.list,
                    onIncrement = { viewModel.increment(it) },
                    onDecrement = { viewModel.decrement(it) })
            }

        }

    }
}