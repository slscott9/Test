package hfad.com.test.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_table")
class TestEntityClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String
)



