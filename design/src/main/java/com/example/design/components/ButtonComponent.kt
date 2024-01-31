package com.example.design.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun ButtonComponent(buttonText: String, navController : NavController, destination : String) {

    Button(onClick = { navController.navigate(destination)}) { Text(text = buttonText) }

}

@Composable
fun BackToMenuButton(navController: NavController) {
    Button(onClick = {navController.navigate("Menu")}) { Text(text = "Назад")}
}