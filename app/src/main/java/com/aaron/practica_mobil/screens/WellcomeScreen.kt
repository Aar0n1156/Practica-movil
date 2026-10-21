package com.aaron.practica_mobil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.ui.theme.Practica_MobilTheme
import com.aaron.practica_mobil.R

@Composable
fun WellcomeScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp).statusBarsPadding(),
        Arrangement.Top,
        Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.perfil2),
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(150.dp)
        )

       Column (modifier = Modifier
           .fillMaxSize()
           .padding(16.dp),
           Arrangement.Top,
           Alignment.CenterHorizontally) {
           Text(text = "Bienvenido",
               textAlign = TextAlign.Center,
               fontStyle = FontStyle.Normal,
               fontFamily = FontFamily.Cursive,
               fontSize = 32.sp
           )

           Text(
           text = "Inicie sesion o Cree una nueva cuenta",
               textAlign = TextAlign.Center
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
               Text("Crear cuenta")
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
               Text("Iniciar Sesion")
           }

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