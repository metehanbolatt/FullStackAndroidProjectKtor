package com.metehanbolat.plugins

import com.metehanbolat.domain.repository.UserDataSource
import com.metehanbolat.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)
        rootRoute()
        tokenVerificationRoute(application, userDataSource)
        getUserInfoRoute(application, userDataSource)
        updateUserRoute(application, userDataSource)
        authorizedRoute()
        unauthorizedRoute()
    }
}
