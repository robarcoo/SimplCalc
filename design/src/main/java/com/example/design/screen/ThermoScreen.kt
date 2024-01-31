package com.example.design.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.design.components.BackToMenuButton
import com.example.design.components.TextComponent
import com.example.design.components.floatFieldComponent
import com.example.design.components.intFieldComponent
import com.example.model.PrintNumbers

@Composable
fun ThermoScreen(navController: NavController) {
    val radioOptions = listOf("Celsius","Kelvin","Fahrenheit")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }
    val state = remember { mutableStateOf(true) }
    var number by remember  { mutableStateOf("0") }
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        BackToMenuButton(navController = navController)
        radioOptions.forEach { tempType ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (tempType == selectedOption),
                    onClick = { selectedOption = tempType }
                )
                Text(
                    text = tempType
                )
            }
        }

        Row{
            RadioButton(
                selected = state.value,
                onClick = { state.value = true
                }
            )
            TextComponent(text = "Summer")
        }
        Row{
            RadioButton(
                selected = !state.value,
                onClick = { state.value = false
                }
            )
            TextComponent(text = "Winter")
        }
        number = floatFieldComponent(value = number, text = "Введите температуру")
        val temp = RightTemp(number.toFloat(), selectedOption)
        ThermoOutput(state = state.value, selectedOption = selectedOption, temp = temp)

    }






}


@Composable
fun ThermoOutput(state : Boolean, selectedOption: String, temp : Float) {
    val summer_max = RightTemp(25.0f, selectedOption)
    val summer_min = RightTemp(22.0f, selectedOption)
    val winter_max = RightTemp(22.0f, selectedOption)
    val winter_min = RightTemp(20.0f, selectedOption)
    val mode_char =
        when (selectedOption) {
            "Celsius" -> "˚C"
            "Kelvin" -> " K"
            "Fahrenheit" -> "˚F"
            else -> throw IllegalArgumentException("Mode chosen incorrectly")
        }
    if (state) {

        TextComponent("The comfortable temperature is from $summer_min to $summer_max $mode_char.")
    } else {
        TextComponent("The comfortable temperature is from $winter_min to $winter_max $mode_char.")
    }

    if (state && temp !in summer_min..summer_max) {
        if (temp > summer_max) {
            TextComponent("Please, make it cooler by ${Math.round(temp - summer_max)} degrees")
        } else {
            TextComponent("Please, make it warmer by ${Math.round(summer_min - temp)} degrees")
        }
    } else if (!state && temp !in winter_min..winter_max) {
        if (temp > winter_max) {
            TextComponent("Please, make it cooler by ${Math.round(temp - winter_max)} degrees")
        } else {
            TextComponent("Please, make it warmer by ${Math.round(winter_min - temp)} degrees")
        }
    }
}

fun RightTemp(number: Float, mode: String): Float {
    return when (mode) {
        "Celsius" -> number
        "Kelvin" -> number + 273.15f
        "Fahrenheit" -> (number * 9 / 5) + 32
        else -> throw IllegalArgumentException("Mode chosen incorrectly")
    }
}