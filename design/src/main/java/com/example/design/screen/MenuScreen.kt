package com.example.design.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.design.components.ButtonComponent


@Composable
fun Menu(navController: NavController) {
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ButtonComponent(buttonText = "Circles", navController, "CircleScreen")
        ButtonComponent(buttonText = "Prime Numbers", navController, "PrimeScreen")
        ButtonComponent(buttonText = "Thermometer", navController, "ThermoScreen")
    }
    
}