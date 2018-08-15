package com.androidapps.starwars.character

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by ankit on 8/11/18.
 */


class CharacterViewModel @Inject constructor(
        val characterRepositoryImpl: CharacterRepositoryImpl) : ViewModel() {

    var charactersLiveData: LiveData<PagedList<Character>>
    private val sourceFactory: CharacterDataSourceFactory
    private val disposables = CompositeDisposable()


    init {
        sourceFactory = CharacterDataSourceFactory(disposables, characterRepositoryImpl.characterApi)
        val config = PagedList.Config.Builder()
                .setPageSize(10)
                .setEnablePlaceholders(false)
                .build()
        charactersLiveData = LivePagedListBuilder<Int, Character>(sourceFactory, config).build()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}