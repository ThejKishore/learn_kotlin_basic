package com.kish.learning


class LogicCondition{

    constructor()

    fun learnIf(){
        println( "Enter the grade")
        var grade = readLine()!!.toDouble()

        println("The grade you entered $grade")

        if(grade >= 80.00)
            println("You passed with A grade")
        else if (grade < 80 && grade >= 60)
            println("you passed with B grade")
        else if(grade < 60 && grade >= 50)
            println("You passed with C grade")
        else
            println("Sorry you did cut the pass marks")
    }

    fun learnWhen(){

        println("Enter the grade")
        var grade = readLine()!!.toDouble()

        println("The grade you entered $grade")

        when (grade){
            in 80..100 -> println("You passed with A grade")
            in 60 .. 80 ->  println("you passed with B grade")
            in 50 .. 60 ->  println("You passed with C grade")
            else ->
                println("Sorry you did cut the pass marks")
        }
    }

    fun learnFor(){
        println(" loop for in 1..10")
        for (index in 1..10) { println(index) }
        println(" loop for in 1 until 10")
        for (index in 1 until 10) { println(index) }

        println(" loop for in 1..10 step 1")
        for (index in 1..10 step 3) { println(index) }
        println(" loop for in 1 until 10 step 2")
        for (index in 1 until 10 step 2) { println(index) }

        println("displaying in the reverse")
        for (index in 10 downTo 1 step 2) {
            println(index)
        }
    }


    fun learnWhile(){
        var i = 0
        while( i < 10 ){
            println(i)
            i++
        }

    }

    fun displayTree(){
        for ( count in 1..10 ) {
            for (count2 in 1..count) {
                print("*")
            }
            println()
        }

    }

    fun displayReverseTree(){
        for (count in 10 downTo 1 ) {
            for (count2 in count downTo 1) {
                print("*")
            }
            println()
        }

    }

}

fun main(args: Array<String>) {

    val logicCondition = LogicCondition()

    logicCondition.learnIf()

    logicCondition.learnWhen()

    logicCondition.learnFor()

    logicCondition.learnWhile()

    logicCondition.displayTree()

    logicCondition.displayReverseTree()

}