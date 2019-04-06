package datadragon.model.cdn.championfulllist

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