package site.ylan.compose.ui.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LinearDeterminateIndicator() {
    val scope = rememberCoroutineScope()
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
    ) {
        Button(
            onClick = {
                loading = true
                scope.launch {
                    loadProgress { progress ->
                        currentProgress = progress
                    }
                    loading = false
                }
            },
            enabled = !loading
        ) {
            Text("Start loading")
        }

        if (loading) {
            LinearProgressIndicator(
                progress = {
                    currentProgress
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
        }
    }
}

suspend fun loadProgress(
    updateProgress: (Float) -> Unit
) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Button(
            onClick = {
                loading = true
            },
            enabled = !loading,
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text("Start loading")
        }

        Button(
            onClick = {
                loading = false
            },
            enabled = loading,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text("End loading")
        }

        if (!loading) return

        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .align(Alignment.Center),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}