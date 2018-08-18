package com.androidapps.starwars.character

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by ankit on 8/11/18.
 */


class CharacterViewModel @Inject constructor(
        val characterRepositoryImpl: CharacterRepositoryImpl,
        val compositeDisposable: CompositeDisposable) : ViewModel() {

    private lateinit var charactersLiveData: LiveData<PagedList<Character>>

    fun loadCharacters() {
        charactersLiveData = characterRepositoryImpl.loadCharacters()
    }

    fun getCharactersLiveData() = charactersLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}