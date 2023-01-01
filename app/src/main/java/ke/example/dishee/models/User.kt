package ke.example.dishee.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "username")
    val userName: String,
    @ColumnInfo(name = "email")
    val email : String,
    @ColumnInfo(name = "password")
    val pass : String
)
