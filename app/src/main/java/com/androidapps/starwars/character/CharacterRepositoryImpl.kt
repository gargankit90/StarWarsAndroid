package com.androidapps.starwars.character

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.androidapps.starwars.shared.StarWarsDb
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by ankit on 8/11/18.
 */

@Singleton
class CharacterRepositoryImpl @Inject constructor(
        val characterApi: CharacterApi,
        val characterDao: CharacterDao,
        val starWarsDb: StarWarsDb) : CharacterRepository {

    override fun loadCharacters(compositeDisposable: CompositeDisposable): LiveData<PagedList<Character>> {
        val sourceFactory = characterDao.getAllCharacters()
        val boundaryCallback = CharacterBoundaryCallback(characterApi, this@CharacterRepositoryImpl, compositeDisposable)
        val config = PagedList.Config.Builder()
                .setPageSize(10)
                .setEnablePlaceholders(false)
                .build()
        return LivePagedListBuilder<Int, Character>(sourceFactory, config)
                .setBoundaryCallback(boundaryCallback)
                .build()
    }
}

interface CharacterRepository {
    fun loadCharacters(compositeDisposable: CompositeDisposable): LiveData<PagedList<Character>>
}