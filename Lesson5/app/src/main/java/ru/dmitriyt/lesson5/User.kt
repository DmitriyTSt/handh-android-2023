package ru.dmitriyt.lesson5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    val id: Int,
    val name: String,
) : Parcelable