package com.aaron.practica_mobil.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.ui.theme.Practica_MobilTheme

@Composable
fun SignUpScreen(navController: NavController){

    var nombre by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var mailError by remember { mutableStateOf(false) }

    fun ValidEmail (email: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp).statusBarsPadding(),
        Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        Alignment.CenterHorizontally
    ){
        Text(
            text = "Crea tu cuenta",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )


        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Nombre")},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        TextField(
            value = mail,
            onValueChange = {
                mail = it
                mailError = !ValidEmail(it)},
            label = {Text("Correo")},
            isError = mailError,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        TextField(
            value = "",
            onValueChange = { },
            label = {Text("Telefono")},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )

        TextField(
            value = pass,
            onValueChange = {pass = it},
            label = {Text("Contraseña")},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        TextField(
            value = "",
            onValueChange = {},
            label = {Text("Confirmar Contraseña")},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50),
                    contentColor = Color.White
                )
            ) {
                Text("Cancelar")
            }

            Button(
                onClick = {
                    navController.navigate("login")
                },
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50),
                    contentColor = Color.White
                )
            ) {
                Text("Aceptar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingUpPreview(){
    Practica_MobilTheme{
        val navController = rememberNavController()
        SignUpScreen(navController)
    }
}