package com.example.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.dogs.model.DogBreed
import com.example.dogs.model.DogDatabase
import kotlinx.coroutines.launch

class DetailViewModel(aplication : Application): BaseViewModel(aplication) {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int){
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDogId(uuid)
            dogLiveData.value = dog
        }
    }
}