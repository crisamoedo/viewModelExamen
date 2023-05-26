package com.example.amoedo_cristina_ex3tadultos.contadores

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class CountersListViewModel : ViewModel() {
    private val _list = mutableStateListOf<Int>()
    val list: List<Int> get() = _list

    fun increment(index: Int) {
        _list[index]++
    }

    fun decrement(index: Int) {
        if (_list[index]>0) _list[index]--
        else throw RuntimeException("Negative counters not allowed")
    }

    fun isShowingCounters() = _list.isNotEmpty()

    fun restart() {
        _list.clear()
    }

    fun setSize(it: Int) {
        repeat(it) { _list.add(0) }
    }


}