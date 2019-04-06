package datadragon.model.cdn.championfulllist

data class Spell(
    val id: String,
    val name: String,
    val description: String,
    val tooltip: String,
    val leveltip: Leveltip?,
    val maxrank: Double,
    val cooldown: List<Double>,
    val cooldownBurn: String,
    val cost: List<Double>,
    val costBurn: String,
    val datavalues: Datavalues,
    val effect: List<Any>,
    val effectBurn: List<Any>,
    val vars: List<Any>,
    val costType: String,
    val maxammo: String,
    val range: List<Double>,
    val rangeBurn: String,
    val image: Image,
    val resource: String?
)