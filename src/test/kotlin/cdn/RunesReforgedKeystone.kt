package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RunesReforgedKeystone {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getRunesReforgedKeystone() = runBlocking {
        println(dataDragon.getRuneReforgedKeystone(8100)?.name)
        println(dataDragon.getRuneReforgedKeystone(8100, locale = Locale.ES_ES)?.name)
        println(dataDragon.getRuneReforgedKeystone(8100, version = "9.5.1")?.name)
        println(dataDragon.getRuneReforgedKeystone(8100, "9.5.1", Locale.ES_ES)?.name)
    }
}