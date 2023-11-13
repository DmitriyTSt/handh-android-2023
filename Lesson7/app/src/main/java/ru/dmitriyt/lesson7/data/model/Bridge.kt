package ru.dmitriyt.lesson7.data.model

import com.google.gson.annotations.SerializedName

class Bridge(
    @SerializedName("name") val name: String?,
    @SerializedName("name_eng") val nameEng: String?,
)
