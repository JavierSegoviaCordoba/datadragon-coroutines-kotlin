package datadragon.model.cdn.sticker

data class StickerDto(
    val type: String,
    val version: String,
    val data: Map<String, Sticker>
)