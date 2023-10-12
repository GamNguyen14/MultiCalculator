package com.example.multicalculator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
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
    fun CalcRow() {
    }
    @Composable
    fun CalcDisplay() {
    }
    @Composable
    fun CalcNumericButton(number: Int, display: MutableState<String>) {
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
