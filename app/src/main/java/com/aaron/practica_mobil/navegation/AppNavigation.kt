package com.aaron.practica_mobil.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.screens.LoginScreen
import com.aaron.practica_mobil.screens.MainScreen
import com.aaron.practica_mobil.screens.SignUpScreen
import com.aaron.practica_mobil.screens.WellcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =  "signup"
    ){
        composable("welcome"){
            WellcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable ("signup"){
            SignUpScreen(navController)
        }
        composable ("main"){
            MainScreen(navController)
        }
    }
}