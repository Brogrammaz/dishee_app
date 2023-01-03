package ke.example.dishee.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ke.example.dishee.models.Recipe


@Dao
interface MainDatabaseDAO {
    @Query("SELECT * FROM recipe_table WHERE id==:id")
    fun getRecipeById(id: Int) : Recipe?
    @Query("SELECT * FROM recipe_table WHERE recipe_name==:name")
    fun getRecipeByName(name: String): Recipe?
    @Query("SELECT * FROM recipe_table")
    fun getAllRecipes(): List<Recipe>?
    @Insert
    fun addRecipe(recipe: Recipe)
}