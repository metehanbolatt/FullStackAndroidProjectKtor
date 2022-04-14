package com.metehanbolat.plugins

import com.metehanbolat.routes.authorizedRoute
import com.metehanbolat.routes.rootRoute
import com.metehanbolat.routes.tokenVerificationRoute
import com.metehanbolat.routes.unauthorizedRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        rootRoute()
        tokenVerificationRoute(application)
        authorizedRoute()
        unauthorizedRoute()
    }
}
