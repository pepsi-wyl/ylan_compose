package site.ylan.compose.ui.Component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MinimalDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        IconButton(
            onClick = {
                expanded = !expanded
            }
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            DropdownMenuItem(
                text = {
                    Text("Option 1")
                },
                onClick = {
                    /* Do something... */
                }
            )
            DropdownMenuItem(
                text = {
                    Text("Option 2")
                },
                onClick = {
                    /* Do something... */
                }
            )
        }
    }
}

@Composable
fun LongBasicDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val menuItemData = List(100) { "Option ${it + 1}" }

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        IconButton(
            onClick = {
                expanded = !expanded
            }
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            menuItemData.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(option)
                    },
                    onClick = {
                        /* Do something... */
                    }
                )
            }
        }
    }
}

@Composable
fun DropdownMenuWithDetails() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = {
                expanded = !expanded
            }
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            DropdownMenuItem(
                text = {
                    Text("Profile")
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Person, contentDescription = null)
                },
                onClick = {
                    /* Do something... */
                }
            )
            DropdownMenuItem(
                text = {
                    Text("Settings")
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Person, contentDescription = null)
                },
                onClick = {
                    /* Do something... */
                }
            )

            HorizontalDivider()

            DropdownMenuItem(
                text = {
                    Text("Send Feedback")
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Person, contentDescription = null)
                },
                trailingIcon = {
                    Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = null)
                },
                onClick = {
                    /* Do something... */
                }
            )

            HorizontalDivider()

            DropdownMenuItem(
                text = {
                    Text("About")
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Person, contentDescription = null)
                },
                onClick = {
                    /* Do something... */
                }
            )
            DropdownMenuItem(
                text = {
                    Text("Help")
                },
                leadingIcon = {
                    Icon(Icons.Outlined.Person, contentDescription = null)
                },
                trailingIcon = {
                    Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = null)
                },
                onClick = {
                    /* Do something... */
                }
            )
        }
    }
}