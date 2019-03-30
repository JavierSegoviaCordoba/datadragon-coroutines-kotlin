package datadragon.service.cdn.championfulllist.dto

data class ChampionFullDto(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, ChampionFull>,
    val keys: Map<Int, String>
)