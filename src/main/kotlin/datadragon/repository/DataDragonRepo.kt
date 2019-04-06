package datadragon.repository

import datadragon.constants.Locale
import datadragon.constants.Platform
import datadragon.datasource.DataDragonService
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
import retrofit2.await

interface DataDragonRepo {

    //api

    suspend fun getVersionsList(): List<String>

    //cdn

    suspend fun getChampion(version: String, locale: Locale, championName: String): ChampionDto
    suspend fun getChampionFullList(version: String, locale: Locale): ChampionFullDto
    suspend fun getChampionList(version: String, locale: Locale): ChampionShortDto
    suspend fun getItem(version: String, locale: Locale): ItemDto
    suspend fun getLanguage(version: String, locale: Locale): LanguageDto
    suspend fun getLanguages(): List<String>
    suspend fun getMap(version: String, locale: Locale): MapDto
    suspend fun getProfileIcon(version: String, locale: Locale): ProfileIconDto
    suspend fun getRunesReforged(version: String, locale: Locale): List<RuneReforged>
    suspend fun getSticker(version: String, locale: Locale): StickerDto
    suspend fun getSummonerSpell(version: String, locale: Locale): SummonerSpellDto

    //realms

    suspend fun getRealms(platform: Platform): Realms
}

class DataDragonApiRepo(private val dataDragonService: DataDragonService) : DataDragonRepo {

    //api

    override suspend fun getVersionsList(): List<String> =
        dataDragonService.GetVersionsList().await()

    //cdn

    override suspend fun getChampion(version: String, locale: Locale, championName: String): ChampionDto =
        dataDragonService.GetChampion(version, locale.id, championName).await()

    override suspend fun getChampionFullList(version: String, locale: Locale): ChampionFullDto =
        dataDragonService.GetChampionFullList(version, locale.id).await()

    override suspend fun getChampionList(version: String, locale: Locale): ChampionShortDto =
        dataDragonService.GetChampionList(version, locale.id).await()

    override suspend fun getItem(version: String, locale: Locale): ItemDto =
        dataDragonService.GetItem(version, locale.id).await()

    override suspend fun getLanguage(version: String, locale: Locale): LanguageDto =
        dataDragonService.GetLanguage(version, locale.id).await()

    override suspend fun getLanguages(): List<String> =
        dataDragonService.GetLanguages().await()

    override suspend fun getMap(version: String, locale: Locale): MapDto =
        dataDragonService.GetMap(version, locale.id).await()

    override suspend fun getProfileIcon(version: String, locale: Locale): ProfileIconDto =
        dataDragonService.GetProfileIcon(version, locale.id).await()

    override suspend fun getRunesReforged(version: String, locale: Locale): List<RuneReforged> =
        dataDragonService.GetRunesReforged(version, locale.id).await()

    override suspend fun getSticker(version: String, locale: Locale): StickerDto =
        dataDragonService.GetSticker(version, locale.id).await()

    override suspend fun getSummonerSpell(version: String, locale: Locale): SummonerSpellDto =
        dataDragonService.GetSummonerSpell(version, locale.id).await()

    //realms

    override suspend fun getRealms(platform: Platform): Realms =
        dataDragonService.GetRealms(platform.localeName).await()

}