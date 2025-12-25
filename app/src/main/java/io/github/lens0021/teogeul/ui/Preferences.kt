package io.github.lens0021.teogeul.ui

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ArrayRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import io.github.lens0021.teogeul.R
import io.github.lens0021.teogeul.KeyStroke

// Utility
@Composable
fun stringArrayResource(
    @ArrayRes id: Int,
): Array<String> {
    val context = LocalContext.current
    return remember(id) { context.resources.getStringArray(id) }
}

// ===== Basic Preference Components =====

@Composable
fun PreferenceCategory(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
    )
}

@Composable
fun PreferenceItem(
    title: String,
    summary: String? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable(enabled = enabled, onClick = onClick),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color =
                    if (enabled) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                    },
            )
            if (summary != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = summary,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

@Composable
fun CheckboxPreference(
    title: String,
    summary: String? = null,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable(enabled = enabled) { onCheckedChange(!checked) },
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color =
                        if (enabled) {
                            MaterialTheme.colorScheme.onSurface
                        } else {
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        },
                )
                if (summary != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = summary,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                enabled = enabled,
            )
        }
    }
}

@Composable
fun ListPreference(
    title: String,
    summary: String? = null,
    entries: List<String>,
    entryValues: List<String>,
    selectedValue: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }

    val displaySummary = summary ?: entries.getOrNull(entryValues.indexOf(selectedValue)) ?: ""

    PreferenceItem(
        title = title,
        summary = displaySummary,
        onClick = { showDialog = true },
        enabled = enabled,
        modifier = modifier,
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(title) },
            text = {
                Column {
                    entries.forEachIndexed { index, entry ->
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onValueChange(entryValues[index])
                                        showDialog = false
                                    }
                                    .padding(vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = selectedValue == entryValues[index],
                                onClick = {
                                    onValueChange(entryValues[index])
                                    showDialog = false
                                },
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = entry)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.dialog_button_cancel))
                }
            },
        )
    }
}

// ===== Custom Preference Components =====

@Composable
fun KeyboardListPreference(
    title: String,
    summary: String,
    entries: List<String>,
    entryValues: List<String>,
    selectedValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ListPreference(
        title = title,
        summary = summary,
        entries = entries,
        entryValues = entryValues,
        selectedValue = selectedValue,
        onValueChange = onValueChange,
        modifier = modifier,
    )
}

@Composable
fun IntEditTextPreference(
    title: String,
    summary: String,
    value: Int,
    onValueChange: (Int) -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }

    PreferenceItem(
        title = title,
        summary = summary,
        onClick = { showDialog = true },
        enabled = enabled,
        modifier = modifier,
    )

    if (showDialog) {
        var textValue by remember { mutableStateOf(value.toString()) }
        val isError = textValue.toIntOrNull() == null

        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(title) },
            text = {
                OutlinedTextField(
                    value = textValue,
                    onValueChange = { textValue = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    isError = isError,
                    singleLine = true,
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        textValue.toIntOrNull()?.let {
                            onValueChange(it)
                            showDialog = false
                        }
                    },
                    enabled = !isError,
                ) {
                    Text(stringResource(R.string.dialog_button_ok))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.dialog_button_cancel))
                }
            },
        )
    }
}

@Composable
fun KeystrokePreference(
    title: String,
    summary: String,
    keystrokeValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }

    PreferenceItem(
        title = title,
        summary = summary,
        onClick = { showDialog = true },
        modifier = modifier,
    )

    if (showDialog) {
        val stroke = remember(keystrokeValue) { KeyStroke.parse(keystrokeValue) }
        var controlChecked by remember { mutableStateOf(stroke.control) }
        var altChecked by remember { mutableStateOf(stroke.alt) }
        var winChecked by remember { mutableStateOf(stroke.win) }
        var shiftChecked by remember { mutableStateOf(stroke.shift) }
        var keyCode by remember { mutableStateOf(stroke.keyCode) }

        Dialog(onDismissRequest = { showDialog = false }) {
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Key display
                    OutlinedTextField(
                        value = KeyEvent.keyCodeToString(keyCode),
                        onValueChange = {},
                        enabled = false,
                        modifier = Modifier.fillMaxWidth(),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Modifier checkboxes
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = controlChecked, onCheckedChange = { controlChecked = it })
                        Text("Ctrl")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = altChecked, onCheckedChange = { altChecked = it })
                        Text("Alt")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = winChecked, onCheckedChange = { winChecked = it })
                        Text("Win")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = shiftChecked, onCheckedChange = { shiftChecked = it })
                        Text("Shift")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Key capture view
                    AndroidView(
                        factory = { context ->
                            View(context).apply {
                                isFocusable = true
                                isFocusableInTouchMode = true
                                setOnKeyListener { _, kc, event ->
                                    if (event.action == KeyEvent.ACTION_DOWN) {
                                        keyCode = kc
                                    }
                                    true
                                }
                                requestFocus()
                            }
                        },
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButton(onClick = { showDialog = false }) {
                            Text(stringResource(R.string.dialog_button_cancel))
                        }
                        TextButton(
                            onClick = {
                                val newStroke = KeyStroke(controlChecked, altChecked, winChecked, shiftChecked, keyCode)
                                onValueChange(newStroke.serialize())
                                showDialog = false
                            },
                        ) {
                            Text(stringResource(R.string.dialog_button_ok))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EnableInputMethodPreference(
    title: String,
    summary: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    PreferenceItem(
        title = title,
        summary = summary,
        onClick = {
            context.startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        },
        modifier = modifier,
    )
}

@Composable
fun PickInputMethodPreference(
    title: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    PreferenceItem(
        title = title,
        onClick = {
            val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showInputMethodPicker()
        },
        modifier = modifier,
    )
}
