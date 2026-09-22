package com.aaron.practica_mobil.ui.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainContact (){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Mis Contactos")
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