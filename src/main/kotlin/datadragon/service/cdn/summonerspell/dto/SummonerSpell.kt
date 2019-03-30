package datadragon.service.cdn.summonerspell.dto

data class SummonerSpell(
    val id: String,
    val name: String,
    val description: String,
    val tooltip: String,
    val maxrank: Double,
    val cooldown: List<Double>,
    val cooldownBurn: String,
    val cost: List<Double>,
    val costBurn: String,
    val datavalues: Datavalues,
    val effect: List<Any>,
    val effectBurn: List<Any>,
    val vars: List<Any>,
    val key: String,
    val summonerLevel: Double,
    val modes: List<String>,
    val costType: String,
    val maxammo: String,
    val range: List<Double>,
    val rangeBurn: String,
    val image: Image,
    val resource: String?
)