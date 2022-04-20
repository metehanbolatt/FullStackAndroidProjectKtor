package com.metehanbolat.plugins

import com.metehanbolat.di.koinModule
import io.ktor.server.application.*
import io.ktor.util.*
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun Application.configureKoin() {
    install(CustomKoinPlugin) {
        modules(koinModule)
    }
}

internal class CustomKoinPlugin(internal val koinApplication: KoinApplication) {
    companion object Plugin: ApplicationPlugin<ApplicationCallPipeline, KoinApplication, CustomKoinPlugin> {
        override val key = AttributeKey<CustomKoinPlugin>("CustomKoinPlugin")
        override fun install(pipeline: ApplicationCallPipeline, configure: KoinApplication.() -> Unit): CustomKoinPlugin {
            val koinApplication = startKoin(appDeclaration = configure)
            return CustomKoinPlugin(koinApplication)
        }
    }
}