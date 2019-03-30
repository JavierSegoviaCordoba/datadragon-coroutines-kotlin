package realms

import datadragon.DataDragon
import datadragon.constants.Platform
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class Realms {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getRealms() = runBlocking {
        val dataDragon = DataDragon()
        println(dataDragon.getRealms())
        println(dataDragon.getRealms(Platform.EUW))

    }
}