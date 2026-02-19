package com.example.aprender_palabras_kmp.data

object PalabrasRepository {
    
    private val palabraDelDia = Palabra(
        titulo = "Call of duty WWII",
        descripcion = "KILROY WAS HERE",
        fecha = "2026-01-29"
    )
    
    fun obtenerPalabraDelDia(): Palabra {
        return palabraDelDia
    }
    
    fun obtenerPalabrasEjemplo(): List<Palabra> {
        return listOf(
            palabraDelDia,
            Palabra(
                titulo = "Hello World",
                descripcion = "Una frase común en programación",
                fecha = "2026-01-28"
            ),
            Palabra(
                titulo = "Kotlin",
                descripcion = "Lenguaje de programación moderno",
                fecha = "2026-01-27"
            )
        )
    }
}
