package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ProfileIcon {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getProfileIcon() = runBlocking {
        println(dataDragon.getProfileIcon(1000)?.image)
        println(dataDragon.getProfileIcon(1000, locale = Locale.ES_ES)?.image)
        println(dataDragon.getProfileIcon(1000, version = "9.5.1")?.image)
        println(dataDragon.getProfileIcon(1000, "9.5.1", Locale.ES_ES)?.image)
    }
}