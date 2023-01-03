package ke.example.dishee.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ke.example.dishee.models.Recipe
import ke.example.dishee.models.User

@Database(entities = [Recipe::class, User::class], version = 1, exportSchema = false)
abstract class DisheeDatabase : RoomDatabase() {
    abstract val mainDatabaseDAO: MainDatabaseDAO

    companion object {
        @Volatile
        private var Instance: DisheeDatabase? = null
        fun getInstance(context: Context): DisheeDatabase {
            synchronized(this) {
                var instance = Instance

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DisheeDatabase::class.java,
                        "Dishee_Database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}