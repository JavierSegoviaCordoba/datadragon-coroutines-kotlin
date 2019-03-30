package cdn

import datadragon.DataDragon
import datadragon.constants.Locale
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class StickerList {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getStickerList() = runBlocking {
        dataDragon.getStickerList().forEach { println(it.image) }
        dataDragon.getStickerList(locale = Locale.ES_ES).forEach { println(it.image) }
        dataDragon.getStickerList(version = "9.1.1").forEach { println(it.image) }
        dataDragon.getStickerList("9.1.1", Locale.ES_ES).forEach { println(it.image) }
    }
}