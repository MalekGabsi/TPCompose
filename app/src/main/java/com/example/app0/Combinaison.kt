package com.example.app0
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip


suspend fun main(){
    val f1 = letters();

    val f2 = numbers();

    f1.collect{
        println(it)
    }
    f2.collect{
        println(it)
    }
    println("res 1 : ")
    val res1 = f1.combine(f2){a,b -> Pair (a,b)}
    res1.collect{
        println(it)
    }

    println("res 2 : ")
    val res2 = f1.zip(f2){a,b -> Pair (a,b)}
    res2.collect{
        println(it)
    }
}




    fun letters (): Flow<String>{
        return flow {
            for (i in 'a'..'c'){
                emit(i.toString())
                delay(200)
            }
        }
    }


    fun numbers(): Flow<Int>{
        return flow {
            for (i in 1..3){
                emit(i)
                delay(300)
            }

        }

    }

