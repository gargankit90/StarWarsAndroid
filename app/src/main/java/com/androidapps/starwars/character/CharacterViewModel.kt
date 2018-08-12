package com.androidapps.starwars.character

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ankit on 8/11/18.
 */


class CharacterViewModel @Inject constructor(
        val applicationContext: Application,
        val characterRepository: CharacterRepository) : AndroidViewModel(applicationContext) {
    var charactersLiveData: MutableLiveData<List<Character>> = MutableLiveData()

    fun loadCharacter(): MutableLiveData<List<Character>> {
        characterRepository.loadCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe() {
                    charactersLiveData.value = it.characterList
                }
        return charactersLiveData
    }
}