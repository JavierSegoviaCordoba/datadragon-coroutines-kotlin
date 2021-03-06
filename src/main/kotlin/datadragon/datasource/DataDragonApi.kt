package datadragon.datasource

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object DataDragonApi {
    private const val baseUrl = "https://ddragon.leagueoflegends.com/"

    private val objectMapper = jacksonObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) // true for testing
        configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
    }

    private val retrofit = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        addConverterFactory(JacksonConverterFactory.create(objectMapper))
    }.build()

    val service: DataDragonService by lazy { retrofit.create(
        DataDragonService::class.java) }
}