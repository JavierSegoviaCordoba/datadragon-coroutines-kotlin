package datadragon.service.cdn.map.dto

data class MapDto(
    val type: String,
    val version: String,
    val data: kotlin.collections.Map<Int, Map>
)