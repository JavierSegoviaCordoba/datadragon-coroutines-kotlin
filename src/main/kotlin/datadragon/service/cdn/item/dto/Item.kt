package datadragon.service.cdn.item.dto

data class Item(
    val name: String,
    val description: String,
    val colloq: String,
    val plaintext: String,
    val specialRecipe: Double,
    val stacks: Double,
    val consumed: Boolean,
    val consumeOnFull: Boolean,
    val inStore: Boolean,
    val hideFromAll: Boolean,
    val requiredChampion: String?,
    val from: List<String>?,
    val into: List<String>?,
    val requiredAlly: String?,
    val image: Image,
    val gold: Gold,
    val tags: List<String>,
    val maps: Map<Int, Boolean>,
    val stats: Stats,
    val effect: Map<String, String>?,
    val depth: Double
)