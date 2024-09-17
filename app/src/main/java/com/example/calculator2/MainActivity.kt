package com.example.calculator2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.calculator2.ui.theme.Calculator2Theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import java.io.DataInput
import kotlin.math.sqrt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculator2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculator()
                }
            }
        }
    }
}



@Composable

fun Calculator() {

    var displayText by remember { mutableStateOf("0.0") }
    var userInput by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf<String?>(null) }
    var answer by remember { mutableStateOf<Double?>(null) }


    fun calculate(userInput: String, answer:Double?, operation: String?): Double {
        if(userInput=="" || operation == null ){
            return userInput.toDouble()
        }
        else if(operation == "+"){
            if (answer != null) {
                return (answer + userInput.toDouble())
            }
        }
        else if (operation == "-"){
            if (answer != null) {
                return (answer - userInput.toDouble())
            }
        }
        else if (operation == "*"){
            if (answer != null) {
                return (answer * userInput.toDouble())
            }
        }
        else if (operation == "/"){
            if (answer != null) {
                return (answer / userInput.toDouble())
            }
        }
        return 0.0
    }

    Column(modifier= Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(100.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    userInput += "1"
                    displayText = userInput
                }
            ) {Text("1")}
            Button(
                onClick = {
                    userInput += "2"
                    displayText = userInput
                }
            ) {Text("2")}
            Button(
                onClick = {
                    userInput += "3"
                    displayText = userInput
                }
            ) {Text("3")}

            Button(//+
                onClick = {
                    if (userInput == "") {

                    }
                    else{
                    operation = "+"
                    answer = userInput.toDouble()
                    userInput = ""
                    displayText = ""
                }}
            ) {Text("+")}
            Button(//*
                onClick = {
                    if (userInput == "") {

                    }
                    else {
                    operation = "*"
                    answer = userInput.toDouble()
                    userInput = ""
                    displayText = ""
                }}
            ) {Text("*")}

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    userInput += "4"
                    displayText = userInput
                }
            ) {Text("4")}
            Button(
                onClick = {
                    userInput += "5"
                    displayText = userInput
                }
            ) {Text("5")}
            Button(
                onClick = {
                    userInput += "6"
                    displayText = userInput
                }
            ) {Text("6")}

            Button(//-
                onClick = {
                    if (userInput == "") {

                    }
                    else{
                    operation = "-"
                    answer = userInput.toDouble()
                    userInput = ""
                    displayText = ""
                }}
            ) {Text("-")}

            Button(//divide
                onClick = {
                    if (userInput == "") {

                    }
                    else{
                    operation = "/"
                    answer = userInput.toDouble()
                    userInput = ""
                    displayText = ""
                }}
            ) {Text("/")}
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    userInput += "7"
                    displayText = userInput
                }
            ) {Text("7")}
            Button(
                onClick = {
                    userInput += "8"
                    displayText = userInput
                }
            ) {Text("8")}
            Button(
                onClick = {
                    userInput += "9"
                    displayText = userInput
                }
            ) {Text("9")}
            Button(//sqrt
                onClick = {
                    if (userInput == "") {

                    }
                    else{
                    operation = null
                    answer = sqrt(userInput.toDouble())
                    userInput = ""
                    displayText = answer.toString()
                }}
            ) {Text("       sqrt      ")}

        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    userInput += "0"
                    displayText = userInput
                }
            ) {Text("         0        ")}
            Button(
                onClick = {
                    userInput += "."
                    displayText = userInput
                }
            ) {Text(".")}
            Button(//=
                onClick = {
                    if (userInput == "") {
                        displayText = userInput.toString()
                    }
                    answer = calculate(userInput, answer, operation)
                    operation = ""
                    userInput = ""
                    displayText = answer.toString()
                    answer = null
                }
            ) {Text("         =        ")}
        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(
                text= displayText
            )
        }
    }
}