package com.example.composecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composecomponents.components.MyBadgeBox
import com.example.composecomponents.model.Routes.*
import com.example.composecomponents.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsTheme {
                // A surface container using the 'background' color from the theme

//                RADIOBUTTON STATE HOSTING
//                var selected by rememberSaveable { mutableStateOf("ejemplo1") }
//                --------------------

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    CHECKBOX STATE HOSTING
//                    val myOptions = getOptions(listOf("uno", "dos", "tres", "cuatro"))
//
//                    Column {
//                        myOptions.forEach {
//                            MyCheckBox3(it)
//                    ---------------------

//                      RADIOBUTTON STATE HOSTING
//                    Column() {
//                        MyRadioButton2(selected, { selected = it })
//                    }
//                    ----------------------

//                    ALERT DIALOG
//                    var show by remember { mutableStateOf(false) }
//                    Box(Modifier.fillMaxSize(), contentAlignment = Center) {
//                        Button(
//                            onClick = { show = true }) {
//                            Text(
//                                text = "Mostrar dialog"
//                            )
//                        }
//                        MyAlertDialog(
//                            show = show,
//                            onDismiss = { show = false },
//                            onConfirm = { Log.i("camilo", "click") }
//                    }
//                    ----------------------

//                    CUSTOM SIMPLE DIALOG
//                    var show by remember { mutableStateOf(false) }
//                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                        Button(onClick = { show = true }) {
//                            Text(text = "mostrar dialog")
//                        }
//                        MySimpleCustomDialog(
//                            show = show,
//                            onDismiss = { show = false })
//                    }
//                    -----------------------
//                    CUSTOM DIALOG
//                    var show by remember { mutableStateOf(false) }
//                    Box(Modifier.fillMaxSize(), contentAlignment = Center) {
//                        Button(
//                            onClick = { show = true }) {
//                            Text(
//                                text = "Mostrar dialog"
//                            )
//                        }
//                        MyConfirmationDialog(show = show, onDismiss = { show = false })
//                    }
//                    ---------------------
//                    NAVIGATION
//                    val navigationController = rememberNavController()
//                    NavHost(
//                        navController = navigationController,
//                        startDestination = Screen1.route
//                    ) {
//                        composable(Screen1.route) { Screen1(navigationController) }
//                        composable(Screen2.route) { Screen2(navigationController) }
//                        composable(Screen3.route) { Screen3(navigationController) }
//                        composable(
//                            Screen4.route,
//                            arguments = listOf(navArgument("age") {
//                                type = NavType.IntType
//                            })
//                        ) { backStackEntry ->
//                            Screen4(
//                                navigationController,
//                                backStackEntry.arguments?.getInt("age") ?: 0
//                            )
//                        }
//                        composable(
//                            Screen5.route,
//                            arguments = listOf(navArgument("name") { defaultValue = "" })
//                        ) { backStackEntry ->
//                            Screen5(
//                                navigationController,
//                                backStackEntry.arguments?.getString("name").orEmpty()
//                            )
//                        }
//                    }
                    MyBadgeBox()

                }
            }
        }
    }
}














