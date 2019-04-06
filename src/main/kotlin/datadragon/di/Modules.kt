package datadragon.di

import datadragon.repository.DataDragonRepo
import datadragon.repository.DataDragonApiRepo
import datadragon.service.DataDragonApi
import org.koin.dsl.module

val modules = module {
    single<DataDragonRepo> { DataDragonApiRepo(DataDragonApi.service) }
}