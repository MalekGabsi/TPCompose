package com.example.app0

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map


suspend fun main(){

    var numbers = values();
    var nums =
    numbers
        .filter { it % 2 != 0 }
        .map { it*3 }

        nums.collect{
        println(it)
    }
    println(nums.fold(0){ acc,i -> acc+i})

}

    fun values(): Flow<Int>{
        return flow {
            for (i in 1..3){
                emit(i)
                delay(200)
            }

        }

    }

