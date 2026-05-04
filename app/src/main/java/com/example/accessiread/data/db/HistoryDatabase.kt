package com.example.accessiread.data.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class HistoryEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, val original: String, val translated: String, val timestamp: Long)

@Dao
interface HistoryDao {
    @Insert suspend fun insert(item: HistoryEntity)
    @Query("SELECT * FROM HistoryEntity ORDER BY timestamp DESC LIMIT 10") suspend fun latest(): List<HistoryEntity>
    @Query("DELETE FROM HistoryEntity WHERE id NOT IN (SELECT id FROM HistoryEntity ORDER BY timestamp DESC LIMIT 10)") suspend fun trim()
}

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() { abstract fun dao(): HistoryDao }
