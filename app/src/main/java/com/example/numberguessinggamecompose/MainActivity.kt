package com.example.numberguessinggamecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.numberguessinggamecompose.ui.theme.NumberGuessingGameComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberGuessingGameComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Title()
        InfoGame()
        SimpleTextField()
        GuessButton()
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
            text = "Try to guess the number i'm thinkingg " +
                    "of form 1 - 1000!",
            fontSize = 20.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(top = 40.dp, start = 10.dp, end= 10.dp),
            fontWeight = FontWeight.Bold,
        )
    }
}

//@Composable
//fun TextField(
//    value: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    readOnly: Boolean = false,
//    textStyle: androidx.compose.ui.text.TextStyle = LocalTextStyle.current,
//    label: @Composable (() -> Unit)? = null,
//    placeholder: @Composable (() -> Unit)? = null,
//    leadingIcon: @Composable (() -> Unit)? = null,
//    trailingIcon: @Composable (() -> Unit)? = null,
//    isError: Boolean = false,
//    visualTransformation: VisualTransformation = VisualTransformation.None,
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
//    keyboardActions: KeyboardActions = KeyboardActions(),
//    singleLine: Boolean = false,
//    maxLines: Int = Int.MAX_VALUE,
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    shape: CornerBasedShape =
//        MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
//    colors: TextFieldColors = TextFieldDefaults.textFieldColors()
//    ) {
//}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText },

            placeholder = { Text(text = "Your Guess")}
        )
    }

}


@Composable
fun GuessButton() {
    Column(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            //your onclick code here
        }) {
            Text(text = "Guess")
        }
    }
}