package com.example.design.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.model.removeLeadingZeros

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun floatFieldComponent(value : String, text : String) : String {
    var newValue by remember { mutableStateOf("0") }
    OutlinedTextField(value = newValue,
        onValueChange = { newValue = when(it.toFloatOrNull()) {
            null -> value
            else -> (if (it.toFloat() > 0 || !text.contains("Радиус")) { removeLeadingZeros(it) } else { newValue })
        }
        } ,
        label = { Text(text) }
    )
    return newValue
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun intFieldComponent(value: String, text: String) : String {
    var newValue by remember { mutableStateOf("0") }
    OutlinedTextField(value = newValue,
        onValueChange = { newValue = when(it.toIntOrNull()) {
            null -> value
            else -> (if (it.toInt() >= 0) { removeLeadingZeros(it) } else { newValue })
        }
        } ,
        label = { Text(text) }
    )
    return newValue
}