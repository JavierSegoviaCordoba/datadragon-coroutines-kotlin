package datadragon.service.cdn.sticker.dto

data class Image(
    val full: String,
    val sprite: String,
    val group: String,
    val x: Double,
    val y: Double,
    val w: Double,
    val h: Double
)