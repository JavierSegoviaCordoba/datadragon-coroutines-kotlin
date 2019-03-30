package datadragon.service.cdn.championshortlist.dto

data class ChampionShort(
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val image: Image,
    val blurb: String,
    val tags: List<String>,
    val partype: String,
    val info: Info,
    val stats: Stats,
    val version: String
)