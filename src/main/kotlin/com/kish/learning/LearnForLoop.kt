package com.kish.learning

import java.math.BigDecimal


fun main(args:Array<String>){
//    System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE")
//    logger.info { "testing" }
    println(" Hello world")

    val listOfPersons = getPersonList()


   val personAbove30 : List<Person> = listOfPersons.asSequence().filter { it.age > 30 }.sortedByDescending { it.age }
           .toCollection(arrayListOf())


   personAbove30.forEach { println("ppl over 30 ${it.fName}") }

   var listOfPer = getPersonList()

    listOfPer.forEach{ println(" data from mutuable list ${it.fName}")}


    listOfPer.filter{isGreaterThan30(it)}.filter {  isMale(it) }.forEach { println(it) }


    println()

    for (index in 1..10) { print(" $index  ,") }

    println()

    //1 ... 9
    for (index in 1 until 10) { print(" $index  ,") }

    //reverse the range
    for (index in 10 downTo  1) { print(" $index  ,") }


    println()

    print(factorial(BigDecimal(5)))

    println()

    println("fibonacci series of 10 no = ")
    fibanocci(10)


    println()

    println( " max =  "+ max(5,6,8,2,4,1))

    process(1)
    process(10)
    process(14)
    process(7)
    process("Hello")
    process( StringBuilder())

    println(nickName("Robert"))
    println(nickName("Venkat"))

    //

    receive(null)
    receive("Thej ")

    println("hello".shout())

    var c = Car()
    println(c.yearOfRegistration)
    c.yearOfRegistration = 2017
    println(c.yearOfRegistration)
//    c.yearOfRegistration = 2019
//    println(c.yearOfRegistration)

    val pizza = Pizza()

    pizza spread "Cheese"
    pizza spread "Sauce"


    val fibonacci = generateSequence(0 to 1) { it.second to it.first + it.second }.map { it.first }
    fibonacci.map { it  }.takeWhile { it < 100 }.forEach { print(" $it ") }

    println()
    //sum of all even no of the fibonacci below 4000000
    println(fibonacci.map { it  }.filter { it%2 == 0 }.takeWhile { it < 400_0000 }.sum())

}

class Car{
    var yearOfRegistration = 2010
    set(value){
        if(value > 2018){
            throw RuntimeException("can't instatiate ")
        }
        field = value
    }


}

fun String.shout() = toUpperCase()

fun max(vararg numbers: Int) = numbers.reduce { max, e-> if(max > e) max else e}

fun getPersonList():List<Person>{
    return  listOf(
            Person("thej","karuneegar",33,'M'),
            Person("abirami","balasubramanain",27,'F'),
            Person("shanaya","karuneegar",2,'F'),
            Person("ganesh","parasuram",57,'M'),
            Person("bharathi","karuneegar",52,'F')
    )
}

fun nickName(name:String): String? {
    if(name == "Robert")
        return "Bob"
    return null
}

fun receive(name:String?){
    println("${name?.length ?:0}")
}

fun factorial(n:BigDecimal ):BigDecimal =
      if( n <= BigDecimal.ONE) {
          print( " $n = ")
          BigDecimal.ONE
      }
      else  {
          print( " $n *")
          factorial(n - BigDecimal.ONE) * n
      }


fun process(input:Any){
    when(input){
        1 -> println("one")
        7,8 -> println("seven or eight")
        in 13..19 -> println("lazy as a teen")
        is String -> println(" i am a String : $input : my length : ${input.length}")

        else -> println("I  don't have any clue")
    }
}

fun fibanocci(n:Int)  {
    print( "0 , 1 , 1 , 2")
    var currentFibonacci = 2
    var previousFibonacci = 1
    var tempStore : Int
    for(i in 4..n){
        tempStore = currentFibonacci;
        currentFibonacci +=previousFibonacci
        previousFibonacci = tempStore
        print(" , $currentFibonacci")
    }
}


fun isGreaterThan30(person: Person) :Boolean =  person.age > 30

fun isMale(person: Person):Boolean = person.sex == 'M'

data class Person (val fName: String? = null,val lName:String? =null , val age: Int ,val sex:Char)


class Pizza{
   infix fun spread(item:String) = println("Spread $item")
}