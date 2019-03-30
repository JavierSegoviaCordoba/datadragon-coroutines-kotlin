package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RunesReforgedRune {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getRunesReforgedKeystone() = runBlocking {
        println(dataDragon.getRuneReforgedRune(8124)?.name)
        println(dataDragon.getRuneReforgedRune(8124, locale = Locale.ES_ES)?.name)
        println(dataDragon.getRuneReforgedRune(8124, version = "9.5.1")?.name)
        println(dataDragon.getRuneReforgedRune(8124, "9.5.1", Locale.ES_ES)?.name)
    }
}