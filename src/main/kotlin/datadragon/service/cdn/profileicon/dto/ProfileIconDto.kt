package datadragon.service.cdn.profileicon.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProfileIconDto(
    val type: String,
    val version: String,
    @JsonProperty("data") val profileIcon: Map<Int, ProfileIcon>
)