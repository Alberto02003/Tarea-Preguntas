package com.example.textfiedl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfiedl.ui.theme.Datos
import com.example.textfiedl.ui.theme.TextFiedlTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              TextFiedlTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
    }

@Composable
fun Main(){
    var questions = ArrayList<Preguntas>()
    var estado by remember { mutableStateOf("") }
    questions = Datos().ArrayLista
    var num by remember { mutableStateOf(0) }
    if (num < 0){num = questions.size-1}
    if (num == questions.size){num = 0}
        Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
            .fillMaxSize()
            ) {
            Text(
                text = stringResource(id = questions[num].texto), modifier = Modifier
                    .padding(top = 15.dp),
            )
            Image(
                modifier = Modifier
                    .padding(horizontal = 10.dp).size(300.dp),
                painter = painterResource(id = questions[num].imagen), contentDescription = "",
            )
            Text(text = estado)
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                FilledTonalButton(modifier = Modifier.padding(horizontal = 5.dp), onClick = {
                    num--
                    estado = ""
                }
                ) {
                    Text(text = "Atras")
                }
                FilledTonalButton(modifier = Modifier.padding(horizontal = 5.dp), onClick = {
                    val random = (0..questions.size - 1).random()
                    num = random
                    estado = ""
                }
                ) {
                    Text(text = "Aleatorio")
                }
                FilledTonalButton(modifier = Modifier.padding(horizontal = 5.dp), onClick = {
                    num++
                    estado = ""
                }
                ) {
                    Text(text = "Siguiente")
                }
            }
            Row(horizontalArrangement = Arrangement.End) {
                FilledTonalButton(modifier = Modifier.padding(horizontal = 5.dp), onClick = {
                    if (questions[num].Respuesta){
                        estado = "Correcto"
                    }else{
                        estado = "Incorrecto"
                    }
                }
                ) {
                    Text(text = "Verdad")
                }
                FilledTonalButton(modifier = Modifier.padding(horizontal = 5.dp), onClick = {
                    if (!questions[num].Respuesta){
                        estado = "Correcto"
                    }else{
                        estado = "Incorrecto"
                    }
                }) {
                    Text(text = "Falso")

                }
            }
        }}




