package com.example.aprender_palabras_kmp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aprender_palabras_kmp.ui.theme.AppColors

@Composable
fun DrawerContent(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.White)
    ) {
        // Header del drawer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppColors.White)
                .padding(vertical = 32.dp, horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Aprender Palabras",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.TextPrimary
            )
        }
        
        HorizontalDivider(
            thickness = 1.dp,
            color = AppColors.DividerColor
        )
        
        // Opciones del menú
        DrawerMenuItem(
            icon = "🏠",
            title = "Palabra del Día",
            isSelected = currentRoute == "palabra_dia",
            onClick = { onNavigate("palabra_dia") }
        )
        
        DrawerMenuItem(
            icon = "🔑",
            title = "Iniciar Sesión",
            isSelected = currentRoute == "login",
            onClick = { onNavigate("login") }
        )
        
        DrawerMenuItem(
            icon = "📝",
            title = "Registrarse",
            isSelected = currentRoute == "registro",
            onClick = { onNavigate("registro") }
        )
        
        DrawerMenuItem(
            icon = "⚙️",
            title = "Configuración",
            isSelected = currentRoute == "configuracion",
            onClick = { onNavigate("configuracion") }
        )
    }
}

@Composable
fun DrawerMenuItem(
    icon: String,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) AppColors.DrawerActiveBackground else AppColors.White
    
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 24.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
        
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = AppColors.TextPrimary
        )
    }
}
