package com.example.multicalculator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcView()
        }
    }

    @Composable
    fun Greeting(text: String) {
        Text(text = text)
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MyApplicationTheme {
            CalcView()
        }
    }


    @Composable
    fun CalcView() {
        val displayText = remember {
            mutableStateOf("0" )
        }
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Row { CalcDisplay(display = displayText) }
            Row {
                Column {
                    for (i in 7 downTo 1 step 3)
                        CalcRow(displayText, startNum = i, numButtons = 3)
                    Row {
                        CalcNumericButton(number = 0, displayText)
                        CalcEqualsButton(displayText)
                    }
                }
                Column {
                    CalcOperationButton(operation = "+")
                    CalcOperationButton(operation = "-")
                    CalcOperationButton(operation = "*")
                    CalcOperationButton(operation = "/")
                }
            }
        }
    }
    @Composable
    fun CalcRow(display: MutableState<String>, startNum: Int, numButtons: Int) {
        val endNum = startNum + numButtons
        Row(modifier = Modifier.padding(0.dp)) {
            for (i in startNum until endNum) {
                CalcNumericButton(number = i, display = display)
            }
        }
    }
    @Composable
    fun CalcDisplay(display: MutableState<String>) {
        Text(
            display.value,
            modifier = Modifier
                .height(200.dp)
                .padding(15.dp)
                .fillMaxWidth(),
            fontSize = 80.sp
        )
    }
    @Composable
    fun CalcNumericButton(number: Int, display: MutableState<String>) {
        Button(
            onClick = { display.value += number.toString() },
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp), shape = CircleShape
        ) {
            Text(number.toString(), fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }
    }
    @Composable
    fun CalcOperationButton(operation: String) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp), shape = CircleShape
        ) {
            Text(operation, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }
    }
    @Composable
    fun CalcEqualsButton(display: MutableState<String>) {
        Button(
            onClick = { display.value = "0" },
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp), shape = CircleShape
        ) {
            Text("=", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }
    }
}
