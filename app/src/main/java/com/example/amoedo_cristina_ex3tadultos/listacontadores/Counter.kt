package com.example.amoedo_cristina_ex3tadultos.listacontadores

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.concurrent.atomic.AtomicInteger

class Counter(var name: String, initialCount: Int = 1) {
    val id = identifier.incrementAndGet()
    var count by mutableStateOf(initialCount)


    companion object {
        private val identifier: AtomicInteger = AtomicInteger(0)
    }

}