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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue




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
            mutableStateOf("0")}
        val leftNumber = rememberSaveable {
            mutableStateOf(0)}
        val rightNumber = rememberSaveable {
            mutableStateOf(0)}
        val operation = rememberSaveable {
            mutableStateOf("")}
        val complete = rememberSaveable {
            mutableStateOf(false)}
        if (complete.value && operation.value.isNotEmpty()) {
            var answer = 0
            when (operation.value) {
                "+" -> answer = leftNumber.value + rightNumber.value
                "-" -> answer = leftNumber.value - rightNumber.value
                "*" -> answer = leftNumber.value * rightNumber.value
                "/" -> answer = leftNumber.value / rightNumber.value
            }
            displayText.value = answer.toString()
            }else if (operation.value.isNotEmpty() && !complete.value){
                displayText.value = rightNumber.value.toString()
            } else {displayText.value = leftNumber.value.toString()}


            fun numberPress(btnNum: Int){
                if (complete.value){
                    leftNumber.value = 0
                    rightNumber.value = 0
                    operation.value = ""
                    complete.value = false
                }
                if (operation.value.isNotEmpty() && !complete.value) {
                    rightNumber.value = (rightNumber.value * 10) + btnNum
                }

                if (operation.value.isEmpty() && !complete.value){
                    leftNumber.value = (leftNumber.value * 10) + btnNum
                }
            }

            fun operationPress(op: String){
                if (!complete.value){
                    operation.value = op
                }
            }
            fun equalPress(){
                complete.value = true
            }

        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Row { CalcDisplay(display = displayText) }
            Row {
                Column {
                    for (i in 7 downTo 1 step 3)
                        CalcRow(onPress = {number -> numberPress(number)}, startNum = i, numButtons = 3)
                    Row {
                        CalcNumericButton(number = 0, onPress = {number -> numberPress(number)})
                        CalcEqualsButton(onPress = {equalPress()})
                    }
                }
                Column {
                    CalcOperationButton(operation = "+", onPress = {op -> operationPress(op)})
                    CalcOperationButton(operation = "-", onPress = {op -> operationPress(op)})
                    CalcOperationButton(operation = "*", onPress = {op -> operationPress(op)})
                    CalcOperationButton(operation = "/", onPress = {op -> operationPress(op)})
                }
            }
        }
    }
    @Composable
    fun CalcRow(onPress: (number: Int) -> Unit, startNum: Int, numButtons: Int) {
        val endNum = startNum + numButtons
        Row(modifier = Modifier.padding(0.dp)) {
            for (i in startNum until endNum) {
                CalcNumericButton(number = i, onPress = onPress)
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
    fun CalcNumericButton(number: Int, onPress: (number: Int) -> Unit) {
        Button(
            onClick = { onPress(number)},
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp), shape = CircleShape,colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(number.toString(), fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
        }
    }
    @Composable
    fun CalcOperationButton(operation : String , onPress : (operation : String)-> Unit){
        Button(
            onClick = { onPress(operation) },
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp), shape = CircleShape,colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(operation, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
        }
    }
    @Composable
    fun CalcEqualsButton(onPress: () -> Unit) {
        Button(
            onClick = { onPress()},
            modifier = Modifier
                .padding(4.dp)
                .size(80.dp), shape = CircleShape, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("=", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
        }
    }
}
