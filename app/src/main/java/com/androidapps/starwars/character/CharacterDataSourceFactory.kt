package com.androidapps.starwars.character

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ankit on 8/14/18.
 */
class CharacterDataSourceFactory(private val compositeDisposable: CompositeDisposable,
                                 private val characterApi: CharacterApi)
    : DataSource.Factory<kotlin.Int, Character>() {

    val characterDataSourceLiveData = MutableLiveData<CharacterDataSource>()

    override fun create(): DataSource<kotlin.Int, Character> {
        val usersDataSource = CharacterDataSource(characterApi, compositeDisposable)
        characterDataSourceLiveData.postValue(usersDataSource)
        return usersDataSource
    }
}