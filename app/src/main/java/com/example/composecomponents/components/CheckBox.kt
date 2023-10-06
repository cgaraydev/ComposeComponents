package com.example.composecomponents.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MyCheckbox1() {
    var state by remember { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            disabledColor = Color.Red,
            checkedColor = Color.Black,
            uncheckedColor = Color.Magenta,
            checkmarkColor = Color.Cyan
        )
    )
}

@Composable
fun MyCheckBox2() {
    var state by remember { mutableStateOf(true) }
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = "ejemplo 1", modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun MyCheckBox3(checkInfo: CheckInfo) {
    Row(Modifier.padding(16.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.size(5.dp))
        Text(text = checkInfo.title, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}

@Composable
fun MyCheckBox4() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.On) }
    TriStateCheckbox(modifier = Modifier.padding(16.dp),
        state = status,
        onClick = { status = when (status){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        } })
}


