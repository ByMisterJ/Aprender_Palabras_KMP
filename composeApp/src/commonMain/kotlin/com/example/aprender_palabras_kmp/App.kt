package com.example.aprender_palabras_kmp

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.aprender_palabras_kmp.data.PalabrasRepository
import com.example.aprender_palabras_kmp.ui.components.DrawerContent
import com.example.aprender_palabras_kmp.ui.screens.PalabraDelDiaScreen
import com.example.aprender_palabras_kmp.ui.theme.AppColors
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var currentRoute by remember { mutableStateOf("palabra_dia") }
        
        // Obtener palabra del día
        val palabraDelDia = remember { PalabrasRepository.obtenerPalabraDelDia() }
        
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(300.dp)
                ) {
                    DrawerContent(
                        currentRoute = currentRoute,
                        onNavigate = { route ->
                            currentRoute = route
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                }
            }
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "Palabra del Día",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menú"
                                )
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = AppColors.LightBlue,
                            titleContentColor = AppColors.TextPrimary,
                            navigationIconContentColor = AppColors.TextPrimary
                        )
                    )
                }
            ) { paddingValues ->
                PalabraDelDiaScreen(
                    palabra = palabraDelDia,
                    onPracticarClick = {
                        println("Practicar nuevas palabras clicked")
                    },
                    onVolverClick = {
                        println("Volver a la palabra del día clicked")
                    },
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}