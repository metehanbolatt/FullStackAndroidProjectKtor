package com.metehanbolat.routes

import com.metehanbolat.domain.model.Endpoint
import com.metehanbolat.domain.model.UserSession
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

fun Route.tokenVerificationRoute() {
    post(Endpoint.TokenVerification.path) {
        call.sessions.set(UserSession(id = "123", name = "Metehan"))
        call.respondRedirect(Endpoint.Authorized.path)
    }
}