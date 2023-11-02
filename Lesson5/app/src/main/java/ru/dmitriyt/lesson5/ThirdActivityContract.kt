package ru.dmitriyt.lesson5

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class ThirdActivityContract : ActivityResultContract<Unit, String>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        return ThirdActivity.createStartIntent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        return if (resultCode == Activity.RESULT_OK) {
            intent?.getStringExtra(ThirdActivity.KEY_QUERY).orEmpty()
        } else {
            ""
        }
    }
}