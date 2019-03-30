package api

import datadragon.DataDragon
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class VersionLists {

    private lateinit var dataDragon: DataDragon

    @Before
    fun before() {
        dataDragon = DataDragon()
    }

    @Test
    fun getVersionLists() = runBlocking {
        println(dataDragon.getVersionLists())
    }
}