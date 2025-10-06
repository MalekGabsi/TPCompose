package com.example.app0

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile

suspend fun main(){
    val f1 = nums();
    f1
        .takeWhile { it < 5 }
        .take(6)
        .collect { println(it) }
    println("first  ")

        println(f1.first {it > 7}) //fait un break apres l'affichage du premier chiffre > 7

}

fun nums(): Flow<Int>{
    return flow {
        for (i in 1..10){
            emit(i)

        }

    }

}