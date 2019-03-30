import datadragon.repository.DataDragonApi
import datadragon.repository.DataDragonApiImpl
import datadragon.service.Retrofit
import org.koin.dsl.module

val modules = module {
    factory<DataDragonApi> { DataDragonApiImpl(Retrofit.service) }
}
