package ru.dmitriyt.lesson1

import kotlin.random.Random

private const val RRR = 3

fun main() {

    val a: Int? by lazy { 5 + 4 }
    val b = 2
    var c = 3
    c = 4
    println("$c")
    val aa: List<Int> = ArrayList()
    val bb: MutableList<Int> = ArrayList()
    val res = mapType(aa)
    bb.add(1)
    bb[0] = 2
    B.create()
    Int::class.java
    val aaa = aa.sorted()
    object : Listener {
        override fun a() {
            TODO("Not yet implemented")
        }
    }
}

inline fun <reified T> mapType(a: List<T>): List<String> {
    return when (T::class.java) {
        Int::class.java -> a.map { "int$it" }
        Float::class.java -> a.map { "float$it" }
        else -> a.map { "other" }
    }
}

fun List<Int>.mySqr(): List<Int> {
    return this + this
}

interface Listener {
    private val q: Int
        get() = 123

    fun a()
    fun b() {
        val b: B? = B().apply {
            str
        }
        with(b) {

        }
        val age = 35
        try {
            age / 0
        } catch (e: Exception) {

        } finally {

        }
        kotlin.runCatching { 1 }
        val ageMoreThan30 = age.takeIf { it > 30 }
        val a = if (b != null) b.qwe else "123"
        val e = b?.let { it.qwe + "123" }
    }
}

sealed interface MyResult {
    data class Success(val a: Int) : MyResult
    object Fail : MyResult
}

fun function1(a: MyResult, b: Int): Float {
    when (a) {
        MyResult.Fail -> TODO()
        is MyResult.Success -> TODO()
    }
}

fun throwA(): Nothing {
    throw Exception("qwe")
}

open class A(
    private val t: Int,
) {
    var a: Int = 1
        get() {
            return field
        }
        set(value) {
            field = value
        }
}

data class C(
    val a: Int,
    val b: Int,
)

class B : A(4) {
    lateinit var qwe: String
    val str: String? = null

    companion object {
        private const val WWW = 1
        const val EEE = 3

        fun create(): B {
            return B()
        }
    }
}