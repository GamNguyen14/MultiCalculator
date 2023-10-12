package com.example.multicalculator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multicalculator.Greeting

class MainActivity : ComponentActivity() {
    @Composable
    fun CalvView(){

    }
    @Composable
    fun CalcRow(display: MutableState<String>, startNum: Int, numButtons: Int) {
        val endNum = startNum + numButtons
        Row(modifier = Modifier.padding(0.dp)) {

        }

        }
    }
    @Composable
    fun CalcDisplay(display: MutableState<String>) {
        Text(display.value,
            modifier = Modifier
                .height(50.dp)
                .padding(5.dp)
                .fillMaxWidth()
        )
    }
    @Composable
    fun CalcNumericButton(number: Int, display: MutableState<String>) {
        Button(onClick = {display.value +=number.toString()},
            modifier = Modifier.padding(4.dp)) {
            Text(number.toString())
        }
    }
    @Composable
    fun CalcOperationButton(operation: String, display: MutableState<String>) {
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(4.dp)) {
            Text(operation)

        }
    }
    @Composable
    fun CalcEqualsButton(display: MutableState<String>) {
        Button(onClick = { display.value = "0" },
            modifier = Modifier.padding(4.dp)) {
            Text("=")

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Boong!")
    }
}
