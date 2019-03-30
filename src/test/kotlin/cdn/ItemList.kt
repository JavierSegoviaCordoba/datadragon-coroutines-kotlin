package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ItemList {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getItemList() = runBlocking {
        dataDragon.getItemList().forEach { println(it.name) }
        dataDragon.getItemList(locale = Locale.ES_ES).forEach { println(it.name) }
        dataDragon.getItemList(version = "9.5.1").forEach { println(it.name) }
        dataDragon.getItemList("9.5.1", Locale.ES_ES).forEach { println(it.name) }
    }
}