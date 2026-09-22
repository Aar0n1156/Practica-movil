package com.aaron.practica_mobil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.practica_mobil.ui.components.Contact
import com.aaron.practica_mobil.ui.components.ContactPreview
import com.aaron.practica_mobil.ui.components.MainContact
import com.aaron.practica_mobil.ui.components.Title
import com.aaron.practica_mobil.ui.theme.Practica_MobilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_MobilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                        Arrangement.SpaceBetween,
                        Alignment.CenterVertically
                    ) {

                    }
                    MainContact()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica_MobilTheme {
        Greeting("Android")
    }
}

@Composable
fun Saludo(nombre:String){
    Text(
        text = "Hola $nombre ESTE ES MI COMPONENTE PERSONALIZADO"
    )
}

@Preview(showBackground = true)
@Composable
fun SaludoPreview(){
    Practica_MobilTheme{
        Saludo(nombre = "SOS")
    }
}