package com.baeldung.exceptionhandling.contact

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contact")
class ContactController {

    @PutMapping
    fun createContact(): Contact {
        return Contact("Vaisakh", "+91 9496 336175", "family")
    }
}