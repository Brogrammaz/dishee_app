package ke.example.dishee

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ke.example.dishee.models.Recipe
import ke.example.dishee.network.DishApi
import kotlinx.coroutines.*
import java.lang.Exception

class FirstFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private var _recipeItems = MutableLiveData<List<Recipe>>()
    val recipeItems: LiveData<List<Recipe>>
        get() = _recipeItems

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private fun getRecipeItems(){
       uiScope.launch {
            val getRecipeItemsDeferred = async { DishApi.retrofitService.getRecipes() }
            try {
                val recipeList = getRecipeItemsDeferred.await()
                _recipeItems.value = recipeList
            }catch (e : Exception){
                e.printStackTrace()
            }
        }

    }
    init {
        getRecipeItems()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}