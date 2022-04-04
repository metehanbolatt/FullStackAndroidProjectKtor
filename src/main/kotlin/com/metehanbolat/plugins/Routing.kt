package com.metehanbolat.plugins

import com.metehanbolat.routes.rootRoute
import com.metehanbolat.routes.unauthorized
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        rootRoute()
        unauthorized()
    }
}
