package com.example.composecomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.composecomponents.R

@Composable
fun MyText1() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "esto es un ejemplo")
        Text(text = "esto es un ejemplo", color = Color.Red)
        Text(text = "esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(text = "esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "esto es un ejemplo", fontSize = 30.sp)
        Text(text = stringResource(id = R.string.ejemplo))
        Text(
            text = "esto es un ejemplo", style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(10f, 10f), blurRadius = 5f
                )
            )
        )
    }
}