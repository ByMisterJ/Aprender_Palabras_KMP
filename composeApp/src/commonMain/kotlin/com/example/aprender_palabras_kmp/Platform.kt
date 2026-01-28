package com.example.aprender_palabras_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform