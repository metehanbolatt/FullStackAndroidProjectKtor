package com.metehanbolat.routes

import com.metehanbolat.domain.model.Endpoint
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.rootRoute() {
    get(path = Endpoint.Root.path) {
        call.respondText("Welcome to Ktor Server!")
    }

}