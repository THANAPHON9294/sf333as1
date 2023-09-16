package com.example.numberguessinggamecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.numberguessinggamecompose.ui.theme.NumberGuessingGameComposeTheme
import kotlin.random.Random

class MainActivity() : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberGuessingGameComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Title()
                        InfoGame()
                        Game()
                    }
                }
            }
        }
    }

    @Composable
    fun Title(){
        Column(modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth(),) {
            Text(
                text = "Number Guessing Game",
                modifier = Modifier.padding(start = 15.dp, top = 20.dp , bottom = 20.dp),
                fontSize = 22.sp,
                color = Color.White,
            )
        }
    }

    @Composable
    fun InfoGame(modifier: Modifier = Modifier) {
        Column() {
            Text(
                text = "Try to guess the number I'm thinking " +
                        "of from 1 - 1000!",
                fontSize = 20.sp,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 50.dp, start = 10.dp, end= 10.dp),
                fontWeight = FontWeight.Bold,
            )
        }
    }

    @Composable
    fun Game() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        var textsubmit by remember { mutableStateOf("") }
        var randnum by remember { mutableStateOf(randomNumber()) }
        var times by remember { mutableStateOf(1) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(top = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = text,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                onValueChange = { newText ->
                    text = newText
                },

                placeholder = { Text(text = "Your Guess") }
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = textsubmit,
                fontSize = 20.sp,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center,

                fontWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                val userInput = text.text.toIntOrNull()
//                println(randnum)
//                println(times)
                if (userInput != null) {
                    if (userInput == randnum) {
                        textsubmit = equal(times)
                        randnum = randomNumber()
                        times = 1
                    } else if (userInput > randnum) {
                        textsubmit = higher()
                        times += 1
                    } else if (userInput < randnum) {
                        textsubmit = lower()
                        times += 1
                    }
                }
                text = TextFieldValue("")
            }) {
                Text(text = "Guess")
            }
        }
    }
}

fun randomNumber() : Int {
    val min = 1
    val max = 1000
    return Random.nextInt(min, max + 1)
}

fun higher() : String {
    return "Hint: It's higher!"
}

fun lower() : String {
    return "Hint: It's lower!"
}

fun equal(number: Int) : String {
    return "Hint: It's equal. You win." + "\n" + "You used $number times"
}