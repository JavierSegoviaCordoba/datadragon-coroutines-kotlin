package datadragon.model.cdn.item

data class Basic(
    val name: String,
    val rune: Rune,
    val gold: Gold,
    val group: String,
    val description: String,
    val colloq: String,
    val plaintext: String,
    val consumed: Boolean,
    val stacks: Double,
    val depth: Double,
    val consumeOnFull: Boolean,
    val from: List<Any>,
    val into: List<Any>,
    val specialRecipe: Double,
    val inStore: Boolean,
    val hideFromAll: Boolean,
    val requiredChampion: String,
    val requiredAlly: String,
    val stats: Stats,
    val tags: List<Any>,
    val maps: Map<Int, Boolean>
)