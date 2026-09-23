package com.aaron.practica_mobil.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MainContact (){
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Mis Contactos",
            color = Color(0xFF0000FF),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold)
        Row {
            Text("Cuadro de Busqueda",
                color = Color(0xFF000000),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)
            Text("      ")
            Text(
                "Boton", color = Color(0xFF000000),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)
        }
        Contact("Aaron","123456789")
        Contact("Aaron","123456789")
        Contact("Aaron","123456789")
        Contact("Aaron","123456789")
        Contact("Aaron","123465789")
    }

}

@Preview(showBackground = true)
@Composable
fun McontacPreview(){
    MainContact()

}