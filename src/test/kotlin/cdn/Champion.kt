package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class Champion {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getChampion() = runBlocking {
        println(dataDragon.getChampion("Graves").id)
        println(dataDragon.getChampion("Graves", locale = Locale.ES_ES).id)
        println(dataDragon.getChampion("Graves", version = "9.5.1").id)
        println(dataDragon.getChampion("Graves", "9.5.1", Locale.ES_ES).id)
    }

    @Test
    fun getChampionShortId() = runBlocking {
        println(dataDragon.getChampionShort("Graves")?.id)
        println(dataDragon.getChampionShort("Graves", locale = Locale.ES_ES)?.id)
        println(dataDragon.getChampionShort("Graves", version = "9.5.1")?.id)
        println(dataDragon.getChampionShort("Graves", "9.5.1", Locale.ES_ES)?.id)
    }

    @Test
    fun getChampionShortKey() = runBlocking {
        println(dataDragon.getChampionShort(104)?.id)
        println(dataDragon.getChampionShort(104, locale = Locale.ES_ES)?.id)
        println(dataDragon.getChampionShort(104, version = "9.5.1")?.id)
        println(dataDragon.getChampionShort(104, "9.5.1", Locale.ES_ES)?.id)
    }

    @Test
    fun getChampionAll() = runBlocking {
        val championList = dataDragon.getChampionList()
        championList.forEach { println(dataDragon.getChampion(it.id).id) }
    }
}