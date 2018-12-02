package com.kish.learning

class Customer {
    var id:Long = 0
    var name: String? = null


    constructor(id: Long, name: String?) {
        this.id = id
        this.name = name
    }

    constructor()


    init {
       if(id == 0L){
           this.id = 1L
       }
       if(name == null || name?.trim().equals("")){
           name = "Something"
       }
   }


    fun display(){
        println(" this is a sample program to test class Customer( id=  ${id} , name = ${name})")
    }
}


fun main(args:Array<String>){
    val customer = Customer(1,"Thej")
    customer.display()

    val cus = Customer()
    cus.name ="Kishore"
    cus.display()

    val cus1 = Customer(name = "Hello",id = 0L)
    cus1.display()
}