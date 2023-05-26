package com.example.amoedo_cristina_ex3tadultos.listacontadores

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class CountersListViewModel : ViewModel() {
    private val _list = mutableStateListOf<Counter>()
    val list: List<Counter> get() = _list


    fun remove(item: Counter) {
        _list.remove(item)
    }

    fun increment(item: Counter) {
        item.count++
    }

    fun decrement(item: Counter) {
        item.count--
    }

    private fun add(item: Counter) =
        _list.add(item)

    fun add(counterName: String) =
        if (_list.none { counterName == it.name })
            add(Counter(counterName))
        else false

    fun getGlobalCount() =
        _list.sumOf { it.count }


}