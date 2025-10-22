package org.countryquizz

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform