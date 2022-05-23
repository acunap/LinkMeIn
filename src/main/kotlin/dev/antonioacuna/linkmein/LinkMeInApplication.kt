package dev.antonioacuna.linkmein

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LinkMeInApplication

fun main(args: Array<String>) {
    runApplication<LinkMeInApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
