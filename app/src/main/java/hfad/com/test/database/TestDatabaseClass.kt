package hfad.com.test.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TestEntityClass::class], version = 1, exportSchema = false)
abstract class TestDatabaseClass: RoomDatabase() {

    abstract val testDao: TestDao

    companion object {
        @Volatile
        private var INSTANCE: TestDatabaseClass? = null

        fun getInstance(context: Context): TestDatabaseClass {
            synchronized(this) {

                var instance = INSTANCE
                // If instance is `null` make a new database instance.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TestDatabaseClass::class.java,
                        "test_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    Log.i("Database", "Created")
                    // Assign INSTANCE to the newly created database.
                    INSTANCE = instance
                }
                // Return instance; smart cast to be non-null.
                return instance
            }
        }
    }
}