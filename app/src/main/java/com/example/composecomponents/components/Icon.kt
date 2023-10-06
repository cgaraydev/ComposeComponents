package com.example.composecomponents.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stairs
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Iconos de Material tienen un default size de 24dp

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Stairs,
        contentDescription = "",
        tint = Color.Green
    )
}

@Composable
fun MyIcon2() {
    Row() {
        Icon(
            imageVector = Icons.Rounded.Verified,
            contentDescription = "",
            tint = Color.Green,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Verified",
            color = Color.Green,
            fontSize = 20.sp
        )
    }
}