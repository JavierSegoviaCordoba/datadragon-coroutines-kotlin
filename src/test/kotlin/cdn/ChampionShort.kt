package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ChampionShort {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getChampionList() = runBlocking {
        dataDragon.getChampionList().forEach { println(it.id) }
        dataDragon.getChampionList(locale = Locale.ES_ES).forEach { println(it.id) }
        dataDragon.getChampionList(version = "9.5.1").forEach { println(it.id) }
        dataDragon.getChampionList("9.5.1", Locale.ES_ES).forEach { println(it.id) }
    }
}