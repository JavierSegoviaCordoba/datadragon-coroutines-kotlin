package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class Item {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getItem() = runBlocking {
        println(dataDragon.getItem(1001)?.name)
        println(dataDragon.getItem(1001, locale = Locale.ES_ES)?.name)
        println(dataDragon.getItem(1001, version = "9.5.1")?.name)
        println(dataDragon.getItem(1001, "9.5.1", Locale.ES_ES)?.name)
    }
}