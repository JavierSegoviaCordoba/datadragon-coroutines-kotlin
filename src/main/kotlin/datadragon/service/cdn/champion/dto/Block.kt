package datadragon.service.cdn.champion.dto

data class Block(
    val type: String,
    val recMath: Boolean,
    val recSteps: Boolean,
    val minSummonerLevel: Double,
    val maxSummonerLevel: Double,
    val showIfSummonerSpell: String?,
    val hideIfSummonerSpell: String?,
    val appendAfterSection: String?,
    val visibleWithAllOf: List<String>?,
    val hiddenWithAnyOf: List<String>?,
    val items: List<Item>
)