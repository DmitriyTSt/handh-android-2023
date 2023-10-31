package ru.dmitriyt.lesson4

sealed class ListItem {

    data class UserItem(val user: User) : ListItem()

    data class ProductItem(val product: Product) : ListItem()
}