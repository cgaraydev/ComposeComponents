package com.example.composecomponents.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar1() {
    var showLoading by remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Green,
                strokeWidth = 5.dp
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar")

        }
    }
}

@Composable
fun MyProgressBar2() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            color = Color.Red,
            backgroundColor = Color.Magenta
        )
    }
}

@Composable
fun MyProgressBar3() {
    var progressStatus by remember { mutableStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = progressStatus,
            color = Color.Red,
            backgroundColor = Color.Magenta
        )
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { progressStatus += .1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressStatus -= .1f }) {
                Text(text = "Reducir")
            }
        }
    }
}