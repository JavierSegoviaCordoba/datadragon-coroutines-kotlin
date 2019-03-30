import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val dataDragon = DataDragon()

    val versionList = dataDragon.getVersionLists()

    val graves = dataDragon.getChampion("Graves") // Last patch version, Locale.EN_US
    val azir = dataDragon.getChampion("Azir", locale = Locale.ES_ES) // Locale.ES_ES
    val yasuo = dataDragon.getChampion("Yasuo", "9.5.1", Locale.ES_ES) // Specific version, Locale.ES_ES

    val championFullList = dataDragon.getChampionFullList() // Last patch version, Locale.EN_US
    val championList = dataDragon.getChampionList() // Last patch version, Locale.EN_US

}