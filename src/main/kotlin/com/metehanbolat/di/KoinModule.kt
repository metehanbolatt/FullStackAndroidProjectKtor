package com.metehanbolat.di

import com.metehanbolat.data.repository.UserDataSourceImpl
import com.metehanbolat.domain.repository.UserDataSource
import com.metehanbolat.util.Constants.DATABASE_NAME
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val koinModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase(DATABASE_NAME)
    }
    single<UserDataSource> {
        UserDataSourceImpl(get())
    }
}