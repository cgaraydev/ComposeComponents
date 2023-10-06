package com.example.composecomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyBadgeBox1() {
    BadgedBox(modifier = Modifier.padding(16.dp),badge = { Badge { Text(text = "3") } }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")

    }
}

@Composable
fun MyBadgeBox2() {
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                }

            },
            selected = false,
            onClick = {})
    }
}

@Composable
fun MyBadgeBox() {
    Column() {
        BadgedBox(modifier = Modifier.padding(16.dp),
            badge = {
                Badge(backgroundColor = Color.Green){
                    Text("3000")
                }

            },
            content = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "estrella")
            })
    }

}
