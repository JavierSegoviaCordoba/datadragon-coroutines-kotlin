package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SummonerSpell {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getSummonerSpell() = runBlocking {
        println(dataDragon.getSummonerSpell("SummonerBarrier")?.name)
        println(dataDragon.getSummonerSpell("SummonerBarrier", locale = Locale.ES_ES)?.name)
        println(dataDragon.getSummonerSpell("SummonerBarrier", version = "9.5.1")?.name)
        println(dataDragon.getSummonerSpell("SummonerBarrier", "9.5.1", Locale.ES_ES)?.name)
    }
}