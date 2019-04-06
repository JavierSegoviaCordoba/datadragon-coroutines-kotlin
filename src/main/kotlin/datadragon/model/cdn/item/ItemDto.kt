package datadragon.model.cdn.item

data class ItemDto(
    val type: String,
    val version: String,
    val basic: Basic,
    val data: Map<Int, Item>,
    val groups: List<Group>,
    val tree: List<Tree>
)