package com.metehanbolat.routes

import com.metehanbolat.domain.model.ApiResponse
import com.metehanbolat.domain.model.Endpoint
import com.metehanbolat.domain.model.UserSession
import com.metehanbolat.domain.repository.UserDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getUserInfoRoute(
    app: Application,
    userDataSource: UserDataSource
) {
    authenticate("auth-session") {
        get(Endpoint.GetUserInfo.path) {
            val userSession = call.principal<UserSession>()
            if (userSession == null) {
                app.log.info("INVALID SESSION")
                call.respondRedirect(Endpoint.Unauthorized.path)
            } else {
                try {
                    call.respond(
                        message = ApiResponse(
                            success = true,
                            user = userDataSource.getUserInfo(userId = userSession.id)
                        ),
                        status = HttpStatusCode.OK
                    )
                } catch (e: Exception) {
                    app.log.info("GETTING USER INFO ERROR: ${e.message}")
                    call.respondRedirect(Endpoint.Unauthorized.path)
                }
            }
        }
    }
}