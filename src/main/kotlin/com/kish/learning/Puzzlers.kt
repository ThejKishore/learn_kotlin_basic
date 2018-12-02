package com.kish.learning

import arrow.core.Either
import arrow.core.Option
import arrow.core.Try
import arrow.core.getOrElse
import arrow.typeclasses.Monoid


fun main(args: Array<String>) {
    val mul = calc(2,3) { i, j -> i * j }
    val sum = calc(2,3) { i, j -> i + j }
    val div = calc(2,3)  { i, j -> i / j }
    val sub = calc(2,3)  { i, j -> i - j }
    println(mul)
    println(sum)
    println(div)
    println(sub)


    val returnedData= tryFunc { calc(1,0){i,j -> i/j} }

    returnedData.map {i -> println(""" inside the right  $i """) }
    returnedData.mapLeft { i -> println("""" inside the left  $i """) }

    val returnedData1= tryFunc { calc(1,1){i,j -> i/j} }

    returnedData1.map {i -> println(""" inside the right 1 $i """) }
    returnedData1.mapLeft { i -> println("""" inside the left 1 $i """) }


    monadSample()

    functorSample()


    val fibonacci = generateSequence(0 to 1) { it.second to it.first + it.second }.map { it.first }
    fibonacci.map { it  }.takeWhile { it < 100 }.forEach { print(" $it,") }
// [0, 2, 2, 4, 6]
}



class StringMonoid : Monoid<String>{
    override fun empty(): String {
        return ""
    }
    override fun String.combine(b: String): String {
        return """${this+','+b}"""
    }
}

fun <T> tryFunc(callBlock: () -> T):Either<Throwable, T>{

    try {
        return Either.right(callBlock.invoke())
    } catch (ex:Exception){
        return Either.left(ex)
    }
}


//monoid...
fun monadSample(){
    val stringMonad = StringMonoid()
    val empty = stringMonad.empty()

    println(stringMonad.combineAll(empty,"a"))
    if ( ",a" == stringMonad.combineAll(empty,"a")) println("equal 1")
    println(stringMonad.combineAll("a",empty))
    if ( "a," == stringMonad.combineAll("a",empty)) println("equal 2")
    println(stringMonad.combineAll("a","b","c","d",empty))
}

//functors ...
fun functorSample(){
    // try converting the string to int and perform addin 1 and get the value...
    val data = Try{ "6".toInt()}.map { it+1 }.toOption().getOrElse { 0 }

    Option

    if( 7 == data) println("equal functor using Try")



    val result = Option.just(6).map { it + 1 }.getOrElse { 0 }

    if( 7 == result) println("equal functor using option ")
}

//Endofunctors



// Higher order functions ...
fun calc(operand1:Int, operand2:Int, operation: (Int, Int) -> Int) :Int {
        return operation(operand1, operand2)
}
