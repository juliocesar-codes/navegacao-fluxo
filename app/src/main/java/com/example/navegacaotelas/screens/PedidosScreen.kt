package com.example.navegacaotelas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PedidosScreen(
    navController: NavController,
    numeroPedido : String
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFCE7010))
            .padding(32.dp)
    ) {
        Text(
            text = "PEDIDOS - ${numeroPedido}",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )

        Button(
            onClick = {navController.navigate("menu")},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier.align(alignment = Alignment.Center)
        ) {
            Text(
                text = "Voltar",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Blue
            )
        }
    }
}