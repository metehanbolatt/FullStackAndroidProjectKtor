package com.metehanbolat.plugins

import com.metehanbolat.domain.repository.UserDataSource
import com.metehanbolat.routes.authorizedRoute
import com.metehanbolat.routes.rootRoute
import com.metehanbolat.routes.tokenVerificationRoute
import com.metehanbolat.routes.unauthorizedRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)
        rootRoute()
        tokenVerificationRoute(application, userDataSource)
        authorizedRoute()
        unauthorizedRoute()
    }
}
