package com.example.navegacaotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacaotelas.screens.LoginScreen
import com.example.navegacaotelas.screens.MenuScreen
import com.example.navegacaotelas.screens.PedidosScreen
import com.example.navegacaotelas.screens.PerfilScreen
import com.example.navegacaotelas.ui.theme.NavegacaoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route = "login"){ LoginScreen(navController)}
                        composable(route = "menu"){ MenuScreen(navController)}
                        composable(route = "perfil/{nome}"){
                            val nome = it.arguments?.getString("nome")
                            PerfilScreen(
                                navController = navController,
                                nome = nome!!
                            )}
                        composable(
                            route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument(name = "numeroPedido"){
                                    defaultValue = "Sem pedidos"
                                }
                            )
                        ) {
                            val numeroPedido = it.arguments?.getString("numeroPedido")

                            PedidosScreen(
                                navController = navController,
                                numeroPedido = numeroPedido!!
                            )
                        }
                    }
                }
            }
        }
    }
}
