package com.example.composecomponents.mylayers

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySpacer() {
    Spacer(30)
}

@Composable
fun Spacer(size: Int) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(size.dp))
}