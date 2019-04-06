package datadragon.datasource

import datadragon.model.cdn.champion.ChampionDto
import datadragon.model.cdn.championfulllist.ChampionFullDto
import datadragon.model.cdn.championshortlist.ChampionShortDto
import datadragon.model.cdn.item.ItemDto
import datadragon.model.cdn.language.LanguageDto
import datadragon.model.cdn.map.MapDto
import datadragon.model.cdn.profileicon.ProfileIconDto
import datadragon.model.cdn.runesreforged.RuneReforged
import datadragon.model.cdn.sticker.StickerDto
import datadragon.model.cdn.summonerspell.SummonerSpellDto
import datadragon.model.realms.Realms
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataDragonService {

    //api___________________________________________________________________________________________________________________

    @GET("api/versions.json")
    fun GetVersionsList(): Call<List<String>>

    //cdn___________________________________________________________________________________________________________________

    @GET("cdn/{version}/data/{locale}/champion/{champion_name}.json")
    fun GetChampion(
        @Path("version") version: String,
        @Path("locale") locale: String,
        @Path("champion_name") champion_name: String
    ): Call<ChampionDto>

    @GET("cdn/{version}/data/{locale}/championFull.json")
    fun GetChampionFullList(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<ChampionFullDto>

    @GET("cdn/{version}/data/{locale}/champion.json")
    fun GetChampionList(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<ChampionShortDto>

    @GET("cdn/{version}/data/{locale}/item.json")
    fun GetItem(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<ItemDto>

    @GET("cdn/{version}/data/{locale}/language.json")
    fun GetLanguage(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<LanguageDto>

    @GET("cdn/languages.json")
    fun GetLanguages(): Call<List<String>>

    @GET("cdn/{version}/data/{locale}/map.json")
    fun GetMap(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<MapDto>

    @GET("cdn/{version}/data/{locale}/profileicon.json")
    fun GetProfileIcon(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<ProfileIconDto>

    @GET("cdn/{version}/data/{locale}/runesReforged.json")
    fun GetRunesReforged(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<List<RuneReforged>>

    @GET("cdn/{version}/data/{locale}/sticker.json")
    fun GetSticker(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<StickerDto>

    @GET("cdn/{version}/data/{locale}/summoner.json")
    fun GetSummonerSpell(
        @Path("version") version: String,
        @Path("locale") locale: String
    ): Call<SummonerSpellDto>

    //Realms________________________________________________________________________________________________________________

    @GET("realms/{region}.json")
    fun GetRealms(@Path("region") region: String): Call<Realms>
}
