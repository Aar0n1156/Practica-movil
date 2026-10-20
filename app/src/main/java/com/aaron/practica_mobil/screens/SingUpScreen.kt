package com.aaron.practica_mobil.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.ui.theme.Practica_MobilTheme

@Composable
fun SignUpScreen(navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp).statusBarsPadding(),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically) {
        Text(
            text = "Pantalla Registro"
        )
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
            Text("Pantalla inicio de Sesion")
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