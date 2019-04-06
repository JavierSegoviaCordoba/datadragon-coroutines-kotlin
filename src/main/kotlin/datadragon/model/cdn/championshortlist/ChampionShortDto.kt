package datadragon.model.cdn.championshortlist

data class ChampionShortDto(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, ChampionShort>

)