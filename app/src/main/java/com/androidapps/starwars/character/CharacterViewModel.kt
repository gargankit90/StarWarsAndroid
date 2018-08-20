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
        val characterRepositoryImpl: CharacterRepositoryImpl) : ViewModel() {

    private lateinit var charactersLiveData: LiveData<PagedList<Character>>
    private val compositeDisposable:CompositeDisposable = CompositeDisposable()

    fun loadCharacters() {
        charactersLiveData = characterRepositoryImpl.loadCharacters(compositeDisposable)
    }

    fun getCharactersLiveData() = charactersLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}