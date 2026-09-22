package com.aaron.practica_mobil.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Title (title: String = "Inserte titulo", modifier: Modifier = Modifier){
    Text(
        text = title,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview(){
    Title()
}