package com.techullurgy.memecut

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform