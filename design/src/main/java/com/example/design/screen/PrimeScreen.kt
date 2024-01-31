package com.example.design.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController
import com.example.design.components.BackToMenuButton
import com.example.design.components.TextComponent
import com.example.design.components.intFieldComponent
import com.example.model.PrintNumbers
import com.example.model.isPrime
import kotlin.text.Typography.bullet

@Composable
fun PrimeScreen(navController: NavController) {
    val state = remember { mutableStateOf(true) }
    var number by remember  { mutableStateOf("0") }
    var numberList by remember { mutableStateOf(emptyList<String>()) }
Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
    BackToMenuButton(navController = navController)
    Row{
        RadioButton(
            selected = state.value,
            onClick = { state.value = true
                numberList = PrintNumbers(number)
            }
        )
        TextComponent(text = "Higher")
    }
    Row{
        RadioButton(
            selected = !state.value,
            onClick = { state.value = false
                numberList = PrintNumbers(number.reversed())

            }
        )
        TextComponent(text = "Lower")
    }

    number = intFieldComponent(value = number, text = "Введите число")
    Print(numberList)


}
}
@Composable
fun Print(numberList: List<String>) {
    Text(
        buildAnnotatedString {
            numberList.forEach {
                append(bullet)
                append("\t\t")
                append(it)
                if (isPrime(it.toInt())) { append(" - prime") }
                append("\n")
            }
        }
    )
}