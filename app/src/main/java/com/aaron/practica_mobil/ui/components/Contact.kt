package com.aaron.practica_mobil.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Contact (contact: String = "Inserte titulo", tel: String,
){

    Row(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically) {
        Text(" IMAGEN ")
        Column()
        {
            Text(contact)
            Text(tel)
            Row() {
                Text("MENSAJE ")
                Text(" LLAMADA")
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ContactPreview(){
    Contact("Aaron Javier Arce Barrera ", "6131403378")

}