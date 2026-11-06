package com.aaron.practica_mobil.screens

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.ui.theme.Practica_MobilTheme

@Composable
fun PermissionScreen(navController: NavController) {
    val context = LocalContext.current
    var permissionGranted by remember { mutableStateOf(false) }

    // 1. El campo/lanzador que maneja la respuesta del diálogo del sistema
    val permissionToRequest = Manifest.permission.CAMERA

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionGranted = isGranted
        if (isGranted) {
            // El usuario aceptó el permiso
        } else {
            // El usuario rechazó el permiso
        }
    }

    // 2. El elemento visual (botón) que actúa como disparador en tu interfaz
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp).statusBarsPadding(),
        Arrangement.SpaceBetween,
        Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                when {
                    ContextCompat.checkSelfPermission(context, permissionToRequest) == PackageManager.PERMISSION_GRANTED -> {
                        permissionGranted = true
                    }
                    else -> {
                        // Dispara la ventana emergente del sistema
                        launcher.launch(permissionToRequest)
                    }
                }
            }
        ) {
            Text(if (permissionGranted) "Permiso Concedido" else "Solicitar Permiso")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PermissionPreview(){
    Practica_MobilTheme{
        val navController = rememberNavController()
        PermissionScreen(navController)
    }
}