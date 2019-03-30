import datadragon.DataDragon
import datadragon.constants.Locale
import datadragon.constants.Platform
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val dataDragon = DataDragon()

    println(dataDragon.getVersionLists())

    println(dataDragon.getChampion("Graves", "9.5.1", Locale.ES_ES).lore)

    println(dataDragon.getChampion("Graves").lore) // LastVersion - Locale.EN_US

    println(dataDragon.getChampionList()[0].blurb) // LastVersion - Locale.EN_US

    println(dataDragon.getChampionFullList("9.5.1", Locale.ES_ES)[0].lore)

    println(dataDragon.getRuneReforgedKeystone(8300)?.name) // LastVersion - Locale.EN_US

    println(dataDragon.getRuneReforgedRune(8112)?.name) // LastVersion - Locale.EN_US

    println(dataDragon.getRealms(Platform.EUW))

}