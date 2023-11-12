package com.example.prototipo_proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototipo_proyecto.ui.theme.Prototipo_proyectoTheme

class LogIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prototipo_proyectoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Prototype()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Prototype(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val imageLogin = R.drawable.loginicon
    Column(modifier.fillMaxSize()){
        Text(
            text = "ProfitPulse",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 30.dp)
                .offset(y = 25.dp)
        )
        Image(
            painter = painterResource(id = imageLogin),
            contentDescription = "Profit Pulse Icon",
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .size(120.dp)
        )
        Text(
            text = stringResource(R.string.Login),
            fontSize = 23.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 10.dp)
        )
        TextField(
            value = username,
            label = {
                Text(
                    text = "Email",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(15, 223, 105)
                )
            },
            onValueChange = {username = it},
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
            )
        )
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(Color.Transparent)
        )
        TextField(
            value = password,
            label = {
                Text(
                    text = "Password",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(15, 223, 105)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {password = it},
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(33.dp)
                .background(Color.Transparent)
        )
        Button(onClick ={ },
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color (32, 193, 102)
            )
        ){
            Text(text = "Iniciar Sesión",
                fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrototypePreview() {
    Prototipo_proyectoTheme {
        Prototype()
    }
}