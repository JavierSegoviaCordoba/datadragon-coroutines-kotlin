package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SummonerSpellList {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getSummonerSpellList() = runBlocking {
        dataDragon.getSummonerSpellList().forEach { println(it.name) }
        dataDragon.getSummonerSpellList(locale = Locale.ES_ES).forEach { println(it.name) }
        dataDragon.getSummonerSpellList(version = "9.1.1").forEach { println(it.name) }
        dataDragon.getSummonerSpellList("9.1.1", Locale.ES_ES).forEach { println(it.name) }
    }
}