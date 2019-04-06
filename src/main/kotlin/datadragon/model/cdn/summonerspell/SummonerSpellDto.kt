package datadragon.model.cdn.summonerspell

import com.fasterxml.jackson.annotation.JsonProperty

data class SummonerSpellDto(
    val type: String,
    val version: String,
    @JsonProperty("data") val summonerSpell: Map<String, SummonerSpell>
)