package com.example.app0

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion

suspend fun main(){

        val f1 = (1..3).asFlow()
        val f2 = (4..6).asFlow()
        val fall = f1.onCompletion { emitAll(f2) }

        val fallbis = flowOf(f1,f2).flatMapConcat { it }

        fallbis.collect {
            value ->
           println(value)
        }
    }

