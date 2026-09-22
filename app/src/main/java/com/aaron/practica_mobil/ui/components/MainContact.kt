package com.aaron.practica_mobil.ui.components

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainContact (){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Mis Contactos",
            color = Color(0xFFFF0000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Row() {
            Text("Cuadro de Buscar")
            Text("Boton")
        }
        Contact("Aaron","12346789")
        Contact("Aaron","12346789")
        Contact("Aaron","12346789")
        Contact("Aaron","12346789")
        Contact("Aaron","12346789")
    }

}

@Preview(showBackground = true)
@Composable
fun McontacPreview(){
    MainContact()

}