package datadragon.service.cdn.runesreforged.dto

data class RuneReforged(
    val id: Int,
    val key: String,
    val icon: String,
    val name: String,
    val slots: List<Slot>
)