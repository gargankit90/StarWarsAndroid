package com.androidapps.starwars.character

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ankit on 8/11/18.
 */


class CharacterViewModel @Inject constructor(
        val characterRepository: CharacterRepository) : ViewModel() {

    var charactersLiveData: MutableLiveData<List<Character>> = MutableLiveData()

    // TODO: Add composite disposables and clear the observables when viewmodel is cleared
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