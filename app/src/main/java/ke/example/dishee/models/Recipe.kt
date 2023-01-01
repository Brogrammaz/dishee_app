package ke.example.dishee.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "ingredients")
    val ingredients : String,
    @ColumnInfo(name = "recipe_name")
    val name: String,
    @ColumnInfo(name = "recipe_author")
    val author : String,
    @ColumnInfo(name = "recipe_description")
    val description : String,
    @ColumnInfo(name = "date_published")
    val datePublished : LocalDateTime,
    @ColumnInfo(name = "recipe_image")
    val imageUrl : String,
    @ColumnInfo(name = "recipe_video")
    val videoUrl : String
)
