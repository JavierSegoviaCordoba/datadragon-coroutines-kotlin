package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ChampionFull {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getChampionFullList() = runBlocking {
        dataDragon.getChampionFullList().forEach { println(it.id) }
        dataDragon.getChampionFullList(locale = Locale.ES_ES).forEach { println(it.id) }
        dataDragon.getChampionFullList(version = "9.5.1").forEach { println(it.id) }
        dataDragon.getChampionFullList("9.5.1", Locale.ES_ES).forEach { println(it.id) }
    }
}