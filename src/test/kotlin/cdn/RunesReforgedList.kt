package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RunesReforgedList {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getRunesReforgedList() = runBlocking {
        dataDragon.getRunesReforgedList().forEach { println(it.name) }
        dataDragon.getRunesReforgedList(locale = Locale.ES_ES).forEach { println(it.name) }
        dataDragon.getRunesReforgedList(version = "9.5.1").forEach { println(it.name) }
        dataDragon.getRunesReforgedList("9.5.1", Locale.ES_ES).forEach { println(it.name) }
    }
}