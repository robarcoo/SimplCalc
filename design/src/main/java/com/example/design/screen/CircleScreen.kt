package com.example.design.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.design.components.BackToMenuButton
import com.example.design.components.TextComponent
import com.example.design.components.floatFieldComponent
import com.example.model.doCirclesIntercept


@Composable
fun CircleScreen(navController: NavController) {
    var x1 by remember { mutableStateOf("0") }
    var y1 by remember  { mutableStateOf("0") }
    var r1 by remember { mutableStateOf("0") }
    var x2 by remember  { mutableStateOf("0") }
    var y2 by remember  { mutableStateOf("0") }
    var r2 by remember  { mutableStateOf("0") }

    var result by remember { mutableStateOf("") }
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        BackToMenuButton(navController = navController)
        Column {
            TextComponent(text = "Первый круг")
            Column {
                x1 = floatFieldComponent(x1, "Координата X первого круга")
                y1 = floatFieldComponent(y1, "Координата Y первого круга")
                r1 = floatFieldComponent(r1, "Радиус первого круга")
            }
            TextComponent(text = "Второй круг")
            Column {
                x2 = floatFieldComponent(x2, "Координата X второго круга")
                y2 = floatFieldComponent(y2, "Координата Y второго круга")
                r2 = floatFieldComponent(r2, "Радиус второго круга")
            }
        }

        Button(onClick = { result = doCirclesIntercept(listOf(x1, y1, r1, x2, y2, r2).map { it.toFloatOrNull() ?: 0.0f})}) {
            TextComponent("Вычислить")
        }
        Row {
            TextComponent("Результат: $result")
        }
    }

}