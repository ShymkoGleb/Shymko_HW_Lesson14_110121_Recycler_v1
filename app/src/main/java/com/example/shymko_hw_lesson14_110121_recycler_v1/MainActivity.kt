package com.example.shymko_hw_lesson14_110121_recycler_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/*
Кожен елемент списку повинен відображати ім’я людини і під ним вік людини.
Також перед “ім’я” та “вік” повинний бути відступ, який залежить від віддаленості в дереві від основи.
Тобто, у “я” відступ може бути 4dp, і тоді у тата і мами буде 8dp, а у бабусь і дідусів 12dp, наприклад.
Точні числа, а також стиль того, як буде виглядати текст (колір, розмір) - на ваш розсуд,
але відступи вибирайте такі, щоб їх легко на око можно було розрізнити.
Крім цього, дерево цього разу повинно включати як мінімум ще й ПРАБАБУСЬ та ПРАДІДУСІВ.
Відображити список потрібно в порядку, який ви отримаєте по такій функції:
Функція f(person) = person, f(mom), f(dad)
Тоді якщо ми маємо таку сім’ю “я, мама, тато, мама мами, тато мами, мама тата, тато тата, то ми отримуємо наступний список, використовуючи функцію f(person)
f(я) = я, f(мама), f(тато) = я, мама, f(мама мами), f(тато мами), тато, f(мама тата), f(тато тата) =
Я, мама, мама мами, тато тата, тато, мама тата, тато тата.
*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val person = getMe(Person("I", 29))
        val adapter = ReciclerAdaptor(person.listOfRelatives)
        rvPersons.adapter = adapter
        rvPersons.layoutManager = LinearLayoutManager(this)
        person.createListRelativesOf(person)
        person.listOfRelatives.add(person)
        adapter.notifyItemInserted(person.listOfRelatives.size - 1)
    }

    fun getMe(person: Person): Person {

        person.mother = Person("Mother", 53)
        person.father = Person("Father", 53)
        person.siblings = listOf(Person("Sister1", 15))
        person.siblings = listOf(Person("Sister2", 2))

        person.mother?.mother = Person("MotherOfMother", 80)
        person.mother?.father = Person("MotherOfFather", 80)
        person.mother?.siblings = listOf(Person("Aunt", 49))

        person.mother?.mother?.mother = Person("MotherOfMotherOfMother")
        person.mother?.mother?.father = Person("MotherOfMotherOfFather")
        person.mother?.father?.mother = Person("MotherOfFatherOfMother")
        person.mother?.father?.father = Person("MotherOfFatherOfFather")

        person.father?.mother = Person("FatherOfMother", 80)
        person.father?.father = Person("FatherOfFather", 80)

        person.father?.mother?.mother = Person("FatherOfMotherOfMother")
        person.father?.mother?.father = Person("FatherOfMotherOfFather")
        person.father?.father?.mother = Person("FatherOfFatherOfMother")
        person.father?.father?.father = Person("FatherOfFatherOfFather")

        return person
    }
}