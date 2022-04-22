package com.metehanbolat.routes

import com.metehanbolat.domain.model.ApiResponse
import com.metehanbolat.domain.model.Endpoint
import com.metehanbolat.domain.model.UserSession
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

fun Route.signOutRoute() {
    authenticate("auth-sessions") {
        get(Endpoint.SignOut.path) {
            call.sessions.clear<UserSession>()
            call.respond(
                message = ApiResponse(success = true),
                status = HttpStatusCode.OK
            )
        }
    }
}