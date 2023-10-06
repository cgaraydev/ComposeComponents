package com.example.composecomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "ejemplo1") },
            text = { Text(text = "soy una descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "CONFIRM")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DISMISS")
                }
            }
        )
    }
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
//    onConfirm: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "ejemplo")
            }
        }
    }
}

//@Composable
//fun MyCustomDialog(
//    show: Boolean,
//    onDismiss: () -> Unit
//) {
//    if (show) {
//        Dialog(onDismissRequest = { onDismiss() }) {
//            Column(
//                Modifier
//                    .background(Color.White)
//                    .padding(24.dp)
//                    .fillMaxWidth()
//            ) {
//                MyTitleDialog(text = "Set backup account")
//                MyAccountItem(
//                    email = "ejemplo1@gmail.com",
//                    drawable = R.drawable.avatar
//                )
//                MyAccountItem(
//                    email = "ejemplo1@gmail.com",
//                    drawable = R.drawable.avatar
//                )
//                MyAccountItem(
//                    email = "ejemplo1@gmail.com",
//                    drawable = R.drawable.avatar
//                )
//                MyAccountItem(
//                    email = "agregar cuenta",
//                    drawable = R.drawable.add
//                )
//            }
//        }
//    }
//}

@Composable
fun MyAccountItem(email: String, @DrawableRes drawable: Int) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .size(40.dp)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), Color.Gray)
                var status by remember { mutableStateOf("") }
                MyRadioButton2(status) { status = it }
                Divider(Modifier.fillMaxWidth(), Color.Gray)
                Row(
                    Modifier
                        .align(Alignment.End)
                        .padding(10.dp)) {
                    TextButton(onClick = {}) {
                        Text(text = "CANCEL")

                    }
                    TextButton(onClick = {}) {
                        Text(text = "OK")

                    }
                }
            }
        }
    }
}

//@Composable
//fun AccountsDialog(
//    accounts: List<Account>,
//    onDismiss: () -> Unit,
//    onAccountClick: (Account) -> Unit,
//    onAddAccountClick: () -> Unit
//) {
//
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        title = {
//            Text(
//                text = "Seleccionar cuenta",
//                style = MaterialTheme.typography.h6
//            )
//        },
//        buttons = {
//            AccountsDialogContent(accounts, onAccountClick, onAddAccountClick)
//        }
//    )
//}
//
//@Composable
//private fun AccountsDialogContent(
//    accounts: List<Account>,
//    onAccountClick: (Account) -> Unit,
//    onAddAccountClick: () -> Unit
//) {
//
//    Column {
//        Spacer(Modifier.height(20.dp))
//
//        accounts.forEach { account ->
//            AccountRow(account, onAccountClick)
//        }
//
//        AddAccountRow(onAddAccountClick)
//
//        Spacer(Modifier.height(8.dp))
//    }
//}
//
//@Composable
//fun AccountRow(account: Account, onAccountClick: (Account) -> Unit) {
//    Row(
//        Modifier
//            .clickable(onClick = { onAccountClick(account) })
//            .fillMaxWidth()
//            .height(56.dp)
//            .padding(horizontal = 24.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            modifier = Modifier
//                .clip(CircleShape)
//                .size(40.dp),
//            painter = painterResource(id = account.avatar),
//            contentDescription = "Cuenta de ${account.email}"
//        )
//
//        Spacer(Modifier.width(20.dp))
//
//        Text(text = account.email)
//    }
//}
//
//@Composable
//fun AddAccountRow(onAddAccountClick: () -> Unit) {
//    Row(
//        modifier = Modifier
//            .clickable(onClick = onAddAccountClick)
//            .fillMaxWidth()
//            .height(56.dp)
//            .padding(horizontal = 24.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .background(color = Color.LightGray),
//            contentAlignment = Alignment.Center
//        ) {
//            Icon(
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .size(24.dp),
//                imageVector = Icons.Filled.Add,
//                contentDescription = "Opción para añadir cuenta"
//            )
//        }
//
//        Spacer(Modifier.width(20.dp))
//
//        Text(text = "Añadir cuenta")
//    }
//}

//data class Account(
//    val email: String,
//    @DrawableRes val avatar: Int = R.drawable.avatar
//)

