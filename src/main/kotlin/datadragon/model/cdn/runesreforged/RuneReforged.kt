package datadragon.model.cdn.runesreforged

data class RuneReforged(
    val id: Int,
    val key: String,
    val icon: String,
    val name: String,
    val slots: List<Slot>
)