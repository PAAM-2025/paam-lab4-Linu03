package com.example.lab_4.data.database

import android.util.Log
import com.example.lab_4.domain.Chiuit
import com.example.lab_4.domain.ChiuitRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ChiuitDbStore(private val appDatabase: AppDatabase) : ChiuitRepository {

    override fun getAll(): List<Chiuit> {
        return appDatabase.chiuitDao().getAll().map { it.toDomainModel() }
    }

    override fun addChiuit(chiuit: Chiuit){
        // TODO 2: Add the new chiuit by invoking the DAO; make sure to use the designated mapper.
        val entity = chiuit.toDbModel()
        appDatabase.chiuitDao().insertChiuit(entity)

    }



    override fun removeChiuit(chiuit: Chiuit) {
        // TODO 5: Remove the chiuit by invoking the DAO; make sure to use the designated mapper.
        val entity = chiuit.toDbModel()
        appDatabase.chiuitDao().deleteChiuit(entity)
    }


    private fun Chiuit.toDbModel() = ChiuitEntity(timestamp, description)

    private fun ChiuitEntity.toDomainModel() = Chiuit(timestamp, description)

}