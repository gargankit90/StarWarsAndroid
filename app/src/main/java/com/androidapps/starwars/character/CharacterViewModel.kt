package com.androidapps.starwars.character

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by ankit on 8/11/18.
 */


class CharacterViewModel @Inject constructor(
        val characterRepository: CharacterRepository) : ViewModel() {

    var charactersLiveData: MutableLiveData<List<Character>> = MutableLiveData()
    private val disposables = CompositeDisposable()

    fun loadCharacter(): MutableLiveData<List<Character>> {
        disposables.add(
                characterRepository.loadCharacters()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe() {
                            charactersLiveData.value = it.characterList
                        })
        return charactersLiveData
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}