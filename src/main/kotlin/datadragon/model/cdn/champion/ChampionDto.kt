package datadragon.model.cdn.champion

data class ChampionDto(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, Champion>
)