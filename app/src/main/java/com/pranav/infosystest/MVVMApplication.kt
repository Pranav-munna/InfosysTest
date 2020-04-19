package com.pranav.infosystest

import android.app.Application
import com.pranav.infosystest.data.db.AppDatabase
import com.pranav.infosystest.data.db.preferences.PreferenceProvider
import com.pranav.infosystest.data.network.MyApi
import com.pranav.infosystest.data.network.NetworkConnectionInterceptor
import com.pranav.infosystest.data.repositories.QuotesRepository
import com.pranav.infosystest.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication :Application(),KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { QuotesRepository(instance(),instance(),instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }
}