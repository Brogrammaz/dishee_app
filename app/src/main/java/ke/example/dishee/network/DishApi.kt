package ke.example.dishee.network

import com.example.dishee.models.Recipe
import com.example.dishee.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://disheebackend.up.railway.app"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface DishApiService{
    @GET("/api/users/")
    fun getUsers():List<User>

    @GET("/api/user/{userid}/")
    fun getUser(@Path("userid") id:Int):User

    @GET("/api/recipes/")
    fun getRecipes():List<Recipe>

    @GET("/api/recipe/{id}")
    fun getRecipe(@Path("id") id: Int):Recipe
}

object DishApi {
    val retrofitService: DishApiService by lazy {
        retrofit.create(DishApiService::class.java)
    }
}