package com.example.shymko_hw_lesson14_110121_recycler_v1

class Person(
    val name: String,
    val age: Int = 110,
    var mother: Person? = null,
    var father: Person? = null,
    var siblings: List<Person>? = null
) {
    var listOfRelatives = mutableListOf<Person>()

    fun createListRelativesOf(person: Person) {
        this.mother?.let {
            person.listOfRelatives.add(it)
            it.createListRelativesOf(person)
        }
        this.father?.let {
            person.listOfRelatives.add(it)
            it.createListRelativesOf(person)
        }
        this.siblings?.let {
            it.forEach {
                person.listOfRelatives.add(it)
                it.createListRelativesOf(person)
            }
        }
    }
}