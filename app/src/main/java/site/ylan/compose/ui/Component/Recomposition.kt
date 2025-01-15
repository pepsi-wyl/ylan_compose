package site.ylan.compose.ui.Component

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Foo() {
    var text by remember { mutableStateOf("") }
    Log.d(TAG, "Foo")
    Button(onClick = {
        text = "$text $text"
    }.also {
        Log.d(TAG, "Button")
    }) {
        Log.d(TAG, "Button content lambda")
        Text(text).also {
            Log.d(TAG, "Text")
        }
    }
}