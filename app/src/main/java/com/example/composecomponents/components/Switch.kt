package com.example.composecomponents.components

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun MySwitch1() {
    var switchState by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = !switchState },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Yellow,
            checkedTrackColor = Color.Black,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackAlpha = 0.3f
        )
//        enabled = false
    )
}