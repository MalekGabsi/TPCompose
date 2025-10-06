package com.example.app0

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow

suspend fun main() {

    val values = numss()
    values
        //.conflate()
        .buffer(3)
        .collect {
            println("collect de $it")
            delay(500) //le collecteur retarde l'émetteur

        } }


    fun numss(): Flow<Int> {
        return flow {
            for (i in 1..10) {

                emit(i)
                delay(200)
                println("emitted $i")

            }
        }
    }

