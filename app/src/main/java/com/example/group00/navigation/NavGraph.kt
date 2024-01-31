package com.example.group00.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.design.screen.CircleScreen
import com.example.design.screen.Menu
import com.example.design.screen.PrimeScreen
import com.example.design.screen.ThermoScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Menu" ) {
        composable(route = "Menu") {
            Menu(navController)
        }

        composable(route = "CircleScreen") {
            CircleScreen(navController)
        }

        composable(route = "PrimeScreen") {
            PrimeScreen(navController)
        }

        composable(route = "ThermoScreen") {
            ThermoScreen(navController)
        }
    }
}