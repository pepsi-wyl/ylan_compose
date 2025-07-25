package site.ylan.compose.ui.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState

@Composable
fun CheckboxMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.systemBarsPadding()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Checkbox"
            )
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }
        Text(
            if (checked) "Checkbox is checked" else "Checkbox is unchecked"
        )
    }
}

@Composable
fun CheckboxParentExample() {
    // Initialize states for the child checkboxes
    val childCheckedStates = remember { mutableStateListOf(false, false, false) }

    // Compute the parent state based on children's states
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.systemBarsPadding()
    ) {
        Column {
            // Parent TriStateCheckbox
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Select all")
                TriStateCheckbox(
                    state = parentState,
                    onClick = {
                        // Determine new state based on current state
                        val newState = parentState != ToggleableState.On
                        childCheckedStates.forEachIndexed { index, _ ->
                            childCheckedStates[index] = newState
                        }
                    }
                )
            }

            // Child Checkboxes
            childCheckedStates.forEachIndexed { index, checked ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Option ${index + 1}")
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { isChecked ->
                            // Update the individual child state
                            childCheckedStates[index] = isChecked
                        }
                    )
                }
            }
        }

        if (childCheckedStates.all { it }) {
            Text("All options selected")
        }
    }
}