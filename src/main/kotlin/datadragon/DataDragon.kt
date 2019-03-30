package datadragon

import datadragon.constants.Locale
import datadragon.constants.Platform
import datadragon.repository.DataDragonApi
import datadragon.service.cdn.champion.dto.Champion
import datadragon.service.cdn.championfulllist.dto.ChampionFull
import datadragon.service.cdn.championshortlist.dto.ChampionShort
import datadragon.service.cdn.item.dto.Item
import datadragon.service.cdn.language.dto.Language
import datadragon.service.cdn.profileicon.dto.ProfileIcon
import datadragon.service.cdn.runesreforged.dto.Rune
import datadragon.service.cdn.runesreforged.dto.RuneReforged
import datadragon.service.cdn.sticker.dto.Sticker
import datadragon.service.cdn.summonerspell.dto.SummonerSpell
import modules
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject

class DataDragon : KoinComponent {

    companion object {
        init {
            startKoin {
                modules(modules)
            }
        }
    }

    private val dataDragonApi by inject<DataDragonApi>()

    //api
    suspend fun getVersionLists() = dataDragonApi.getVersionsList()

    suspend fun getChampion(championId: String, version: String = "", locale: Locale = Locale.EN_US): Champion =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getChampion(lastVersion, locale, championId).data.entries.first().value
        }

    //cdn
    suspend fun getChampionShort(
        championId: String,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): ChampionShort? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getChampionList(lastVersion, locale).data.values.toList()
                .firstOrNull { it.id == championId }
        }

    suspend fun getChampionShort(
        championKey: Int,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): ChampionShort? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getChampionList(lastVersion, locale).data.values.toList()
                .firstOrNull { it.key == championKey.toString() }
        }

    suspend fun getChampionFullList(version: String = "", locale: Locale = Locale.EN_US): List<ChampionFull> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getChampionFullList(lastVersion, locale).data.values.toList()
        }

    suspend fun getChampionList(version: String = "", locale: Locale = Locale.EN_US): List<ChampionShort> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getChampionList(lastVersion, locale).data.values.toList()
        }

    suspend fun getItemList(version: String = "", locale: Locale = Locale.EN_US): List<Item> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getItem(lastVersion, locale).data.values.toList()
        }

    suspend fun getItem(itemId: Int, version: String = "", locale: Locale = Locale.EN_US): Item? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getItem(lastVersion, locale).data[itemId]
        }

    suspend fun getLanguage(version: String = "", locale: Locale = Locale.EN_US): Language =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getLanguage(lastVersion, locale).language
        }

    suspend fun getLanguages() = dataDragonApi.getLanguages()

    suspend fun getProfileIconList(version: String = "", locale: Locale = Locale.EN_US): List<ProfileIcon> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getProfileIcon(lastVersion, locale).profileIcon.values.toList()
        }

    suspend fun getProfileIcon(profileIconId: Int, version: String = "", locale: Locale = Locale.EN_US): ProfileIcon? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getProfileIcon(lastVersion, locale).profileIcon[profileIconId]
        }

    suspend fun getRunesReforgedList(version: String = "", locale: Locale = Locale.EN_US): List<RuneReforged> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getRunesReforged(lastVersion, locale)
        }

    suspend fun getRuneReforgedKeystone(
        runeReforgedId: Int,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): RuneReforged? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getRunesReforged(lastVersion, locale).firstOrNull { it.id == runeReforgedId }
        }

    suspend fun getRuneReforgedRune(
        runeReforgedId: Int,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): Rune? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            val runeReforgedList = dataDragonApi.getRunesReforged(lastVersion, locale)
            val slots = runeReforgedList.flatMap { it.slots }
            val runeList = slots.flatMap { it.runes }
            runeList.firstOrNull { it.id == runeReforgedId }
        }

    suspend fun getStickerList(version: String = "", locale: Locale = Locale.EN_US): List<Sticker> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getSticker(lastVersion, locale).data.values.toList()
        }

    suspend fun getSummonerSpellList(version: String = "", locale: Locale = Locale.EN_US): List<SummonerSpell> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getSummonerSpell(lastVersion, locale).summonerSpell.values.toList()
        }

    suspend fun getSummonerSpell(
        summonerSpellId: String,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): SummonerSpell? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonApi.getSummonerSpell(lastVersion, locale).summonerSpell.values.toList()
                .firstOrNull { it.id == summonerSpellId }
        }

    //realms
    suspend fun getRealms(platform: Platform = Platform.NA) = dataDragonApi.getRealms(platform)

}