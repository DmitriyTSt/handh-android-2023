package ru.dmitriyt.lesson10.presentation.extensions

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.view.ViewGroup

fun View.toBitmap(size: Int? = null): Bitmap {
    measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val bitmap = Bitmap.createBitmap(size ?: measuredWidth, size ?: measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    layout(0, 0, size ?: measuredWidth, size ?: measuredHeight)
    draw(canvas)
    return bitmap
}