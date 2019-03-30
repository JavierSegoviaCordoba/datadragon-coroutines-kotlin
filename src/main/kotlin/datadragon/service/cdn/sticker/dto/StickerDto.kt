package datadragon.service.cdn.sticker.dto

data class StickerDto(
    val type: String,
    val version: String,
    val data: Map<String, Sticker>
)