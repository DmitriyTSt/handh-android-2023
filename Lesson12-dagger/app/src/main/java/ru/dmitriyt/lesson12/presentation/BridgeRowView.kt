package ru.dmitriyt.lesson12.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import ru.dmitriyt.lesson12.R
import ru.dmitriyt.lesson12.databinding.ViewBridgeRowBinding

class BridgeRowView : ConstraintLayout {

    private val binding = ViewBridgeRowBinding.inflate(LayoutInflater.from(context), this)

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet? = null) {
        val attrs = context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.BridgeRowView,
            0,
            0
        )
        try {
            val color = attrs.getColor(R.styleable.BridgeRowView_bridgeTitleColor, ContextCompat.getColor(context, R.color.black))
            setTitleTextColor(color)
        } finally {
            attrs.recycle()
        }
    }

    fun bind(bridge: Bridge) = with(binding) {
        textViewTitle.text = bridge.title
        textViewDescription.text = "bridge.description"
    }

    fun setTitleTextColor(@ColorInt color: Int) {
        binding.textViewTitle.setTextColor(color)
    }
}