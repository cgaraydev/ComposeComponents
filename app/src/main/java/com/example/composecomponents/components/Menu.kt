package com.example.composecomponents.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun MyDropDownMenu1() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val ejemploLista = listOf("uno", "dos", "tres", "cuatro", "cinco")
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            ejemploLista.forEach {
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = it
                }) {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
fun TasksUi() {
    var taskMenuOpen by remember { mutableStateOf(false) }
    var action by remember { mutableStateOf("Ninguna") }

    Box(
        Modifier
            .border(width = 1.dp, shape = RectangleShape, color = Color.LightGray)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(56.dp)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {

                Text(
                    text = "Limpiar alacena"
                )
                Text(text = "Acción: $action", style = MaterialTheme.typography.caption)
            }

        }
        IconButton(
            onClick = { taskMenuOpen = true },
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "Acciones para tarea"
            )
            TaskMenu(
                expanded = taskMenuOpen,
                onItemClick = { action = it },
                onDismiss = {
                    taskMenuOpen = false
                }
            )
        }
    }
}

@Composable
fun TaskMenu(
    expanded: Boolean,
    onItemClick: (String) -> Unit,
    onDismiss: () -> Unit
) {

    val options = listOf(
        "Cambiar nombre",
        "Enviar por email",
        "Copiar enlace",
        "Ocultar subtareas completas",
        "Eliminar"
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    onItemClick(option)
                    onDismiss()
                }
            ) {
                Text(text = option)
            }
        }
    }
}

@Composable
fun ThemedTaskMenu() {
    var taskMenuOpen by remember { mutableStateOf(false) }
    Box {
        OutlinedButton(onClick = { taskMenuOpen = true }) {
            Text(text = "Abrir Menú")
        }
        MaterialTheme(
            colors = MaterialTheme.colors.copy(surface = Color(0xFFe3f2fd)),
            shapes = MaterialTheme.shapes.copy(medium = CutCornerShape(size = 25f))
        ) {
            TaskMenu(
                expanded = taskMenuOpen,
                onItemClick = {},
                onDismiss = { taskMenuOpen = false }
            )
        }
    }
}
