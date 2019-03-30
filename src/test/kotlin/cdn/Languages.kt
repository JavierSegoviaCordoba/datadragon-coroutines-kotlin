package cdn

import datadragon.DataDragon
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class Languages {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getLanguages() = runBlocking {
        println(dataDragon.getLanguages())
    }
}