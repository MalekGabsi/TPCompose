package com.example.app0

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DiceRepository {

    fun generateFlow(n: Int): Flow<Int> {
        return flow {
            repeat(n) { // génère n tirages puis s'arrête
                emit((1..6).random())
                delay(1000) // 1 seconde entre chaque tirage
            }
        }
    }
}
