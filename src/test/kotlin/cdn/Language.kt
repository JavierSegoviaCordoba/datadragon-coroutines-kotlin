package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class Language {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getLanguage() = runBlocking {
        println(dataDragon.getLanguage().Boots)
        println(dataDragon.getLanguage(locale = Locale.ES_ES).Boots)
        println(dataDragon.getLanguage(version = "9.5.1").Boots)
        println(dataDragon.getLanguage("9.5.1", Locale.ES_ES).Boots)
    }
}