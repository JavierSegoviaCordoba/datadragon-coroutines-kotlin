package datadragon.model.cdn.map

data class MapDto(
    val type: String,
    val version: String,
    val data: kotlin.collections.Map<Int, Map>
)