package com.example.prototipo_proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototipo_proyecto.ui.theme.Prototipo_proyectoTheme

class CreateAccount : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prototipo_proyectoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewAccount()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewAccount(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    Column(modifier.fillMaxSize()
        .padding(30.dp)){
        Text(
            text = stringResource(R.string.NewAccount_Header),
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier
                .align(Alignment.Start)
                .padding(start = 40.dp, top = 60.dp)

        )
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(23.dp)
                .background(Color.Transparent)
        )
        TextField(
            value = username,
            label = {
                Text(
                    text = stringResource(R.string.NewAccount_Email),
                    fontSize = 16.sp,
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
                    text = stringResource(R.string.NewAccount_Password),
                    fontSize = 16.sp,
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
                .height(29.dp)
                .background(Color.Transparent)
        )

        Row{
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = {  },
                modifier = modifier
                    .padding(start = 35.dp)
            )
            Text(
                text= stringResource(R.string.Accept_TermsConditions),
                fontSize = 16.sp,
                color = Color(156,156,156),
                modifier = modifier
                    .padding(top = 12.dp)
            )
        }

        Button(onClick ={ },
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color (32, 193, 102)
            )
        ){
            Text(text = stringResource(R.string.Create),
                fontSize = 20.sp
            )
        }
        Row(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        ){
            Text (
                text = stringResource(R.string.haveAccount),
                color = Color(151,151,151),
                fontSize = 18.sp,
                modifier = modifier
                    .padding(top = 14.dp)
            )
            Button(
                onClick={},
                modifier = modifier
                    .height(50.dp)
                    .width(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color (255, 255, 255)
                )
            ){
                Text(
                    text= stringResource(R.string.Login),
                    fontSize = 18.sp,
                    color = Color(151,151,151),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Prototipo_proyectoTheme {
        NewAccount()
    }
}