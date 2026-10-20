package com.aaron.practica_mobil.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.AsyncImage

@Composable
fun WellcomeScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp).statusBarsPadding(),
        Arrangement.SpaceBetween,
        Alignment.CenterHorizontally) {
        val imagen = "https://w7.pngwing.com/pngs/981/645/png-transparent-default-profile-united-states-computer-icons-desktop-free-high-quality-person-icon-miscellaneous-silhouette-symbol.png"
        AsyncImage(model = imagen,
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Pantalla de Bienvenida"
        )


        Button(
            onClick = {
                navController.navigate("signup")
            },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50),
                contentColor = Color.White
            )
        ) {
            Text("Pantalla de Registro")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellcomePreview(){
    Practica_MobilTheme{
        val navController = rememberNavController()
        WellcomeScreen(navController)
    }
}