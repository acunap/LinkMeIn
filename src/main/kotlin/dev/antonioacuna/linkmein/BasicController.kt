package dev.antonioacuna.linkmein

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BasicController {
    @GetMapping
    fun get() : String = "Hello, world!"
}