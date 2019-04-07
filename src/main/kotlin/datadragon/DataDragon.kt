package datadragon

import datadragon.constants.Locale
import datadragon.constants.Platform
import datadragon.di.modules
import datadragon.model.cdn.champion.Champion
import datadragon.model.cdn.championfulllist.ChampionFull
import datadragon.model.cdn.championshortlist.ChampionShort
import datadragon.model.cdn.item.Item
import datadragon.model.cdn.language.Language
import datadragon.model.cdn.profileicon.ProfileIcon
import datadragon.model.cdn.runesreforged.Rune
import datadragon.model.cdn.runesreforged.RuneReforged
import datadragon.model.cdn.sticker.Sticker
import datadragon.model.cdn.summonerspell.SummonerSpell
import datadragon.repository.DataDragonRepo
import org.koin.core.Koin
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.koinApplication

class DataDragon : DataDragonKoinComponent() {

    private val dataDragonRepo by inject<DataDragonRepo>()

    //api
    suspend fun getVersionLists() = dataDragonRepo.getVersionsList()

    suspend fun getChampion(championId: String, version: String = "", locale: Locale = Locale.EN_US): Champion =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getChampion(lastVersion, locale, championId).data.entries.first().value
        }

    //cdn
    suspend fun getChampionShort(
        championId: String,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): ChampionShort? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getChampionList(lastVersion, locale).data.values.toList()
                .firstOrNull { it.id == championId }
        }

    suspend fun getChampionShort(
        championKey: Int,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): ChampionShort? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getChampionList(lastVersion, locale).data.values.toList()
                .firstOrNull { it.key == championKey.toString() }
        }

    suspend fun getChampionFullList(version: String = "", locale: Locale = Locale.EN_US): List<ChampionFull> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getChampionFullList(lastVersion, locale).data.values.toList()
        }

    suspend fun getChampionList(version: String = "", locale: Locale = Locale.EN_US): List<ChampionShort> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getChampionList(lastVersion, locale).data.values.toList()
        }

    suspend fun getItemList(version: String = "", locale: Locale = Locale.EN_US): List<Item> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getItem(lastVersion, locale).data.values.toList()
        }

    suspend fun getItem(itemId: Int, version: String = "", locale: Locale = Locale.EN_US): Item? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getItem(lastVersion, locale).data[itemId]
        }

    suspend fun getLanguage(version: String = "", locale: Locale = Locale.EN_US): Language =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getLanguage(lastVersion, locale).language
        }

    suspend fun getLanguages() = dataDragonRepo.getLanguages()

    suspend fun getProfileIconList(version: String = "", locale: Locale = Locale.EN_US): List<ProfileIcon> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getProfileIcon(lastVersion, locale).profileIcon.values.toList()
        }

    suspend fun getProfileIcon(profileIconId: Int, version: String = "", locale: Locale = Locale.EN_US): ProfileIcon? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getProfileIcon(lastVersion, locale).profileIcon[profileIconId]
        }

    suspend fun getRunesReforgedList(version: String = "", locale: Locale = Locale.EN_US): List<RuneReforged> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getRunesReforged(lastVersion, locale)
        }

    suspend fun getRuneReforgedKeystone(
        runeReforgedId: Int,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): RuneReforged? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getRunesReforged(lastVersion, locale).firstOrNull { it.id == runeReforgedId }
        }

    suspend fun getRuneReforgedRune(
        runeReforgedId: Int,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): Rune? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            val runeReforgedList = dataDragonRepo.getRunesReforged(lastVersion, locale)
            val slots = runeReforgedList.flatMap { it.slots }
            val runeList = slots.flatMap { it.runes }
            runeList.firstOrNull { it.id == runeReforgedId }
        }

    suspend fun getStickerList(version: String = "", locale: Locale = Locale.EN_US): List<Sticker> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getSticker(lastVersion, locale).data.values.toList()
        }

    suspend fun getSummonerSpellList(version: String = "", locale: Locale = Locale.EN_US): List<SummonerSpell> =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getSummonerSpell(lastVersion, locale).summonerSpell.values.toList()
        }

    suspend fun getSummonerSpell(
        summonerSpellId: String,
        version: String = "",
        locale: Locale = Locale.EN_US
    ): SummonerSpell? =
        with(version) {
            val lastVersion = if (version == "") getVersionLists()[0] else version
            dataDragonRepo.getSummonerSpell(lastVersion, locale).summonerSpell.values.toList()
                .firstOrNull { it.id == summonerSpellId }
        }

    //realms
    suspend fun getRealms(platform: Platform = Platform.NA) = dataDragonRepo.getRealms(platform)

}

abstract class DataDragonKoinComponent : KoinComponent {

    companion object {
        val koinApp = koinApplication { modules(modules) }.koin
    }

    override fun getKoin(): Koin = koinApp

}