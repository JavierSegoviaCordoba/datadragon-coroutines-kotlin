package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ProfileIconList {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getProfileIconList() = runBlocking {
        dataDragon.getProfileIconList().forEach { println(it.id) }
        dataDragon.getProfileIconList(locale = Locale.ES_ES).forEach { println(it.id) }
        dataDragon.getProfileIconList(version = "9.5.1").forEach { println(it.id) }
        dataDragon.getProfileIconList("9.5.1", Locale.ES_ES).forEach { println(it.id) }
    }
}