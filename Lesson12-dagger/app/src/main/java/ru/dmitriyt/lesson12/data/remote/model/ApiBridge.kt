package ru.dmitriyt.lesson12.data.remote.model

import com.google.gson.annotations.SerializedName
import ru.dmitriyt.lesson12.presentation.Bridge

class ApiBridge(
    @SerializedName("name") val name: String?,
    @SerializedName("name_eng") val nameEng: String?,
)

fun ApiBridge.toModel(): Bridge {
    return Bridge(
        title = name.orEmpty(),
    )
}