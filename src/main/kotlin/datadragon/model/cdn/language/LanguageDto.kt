package datadragon.model.cdn.language

import com.fasterxml.jackson.annotation.JsonProperty

data class LanguageDto(
    val type: String,
    val version: String,
    @JsonProperty("data") val language: Language,
    val tree: Tree
)