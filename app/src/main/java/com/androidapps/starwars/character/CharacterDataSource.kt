package com.androidapps.starwars.character

import android.arch.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ankit on 8/12/18.
 */
class CharacterDataSource(private val characterApi: CharacterApi,
                          private val compositeDisposable: CompositeDisposable): PageKeyedDataSource<kotlin.Int, Character>() {
    override fun loadInitial(params: LoadInitialParams<kotlin.Int>, callback: LoadInitialCallback<kotlin.Int, Character>) {
        compositeDisposable.add(characterApi.getAllCharacters(1.toString()).subscribe({characters -> callback.onResult(characters.characterList, null, getPageNumber(characters.next))}))
    }

    override fun loadAfter(params: LoadParams<kotlin.Int>, callback: LoadCallback<kotlin.Int, Character>) {
        compositeDisposable.add(characterApi.getAllCharacters(params.key.toString()).subscribe({characters ->
            val key:Int?
            if(characters.next == null) {
                key = null
            } else {
                key = getPageNumber(characters.next)
            }
            callback.onResult(characters.characterList, key)}))
    }

    override fun loadBefore(params: LoadParams<kotlin.Int>, callback: LoadCallback<kotlin.Int, Character>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getPageNumber(data:String):Int {
        val listOfString = data.split("/")
        var lastString = listOfString[listOfString.size - 1]
        lastString = lastString.subSequence(lastString.indexOf("=")+1, lastString.length).toString()
        return lastString.toInt()
    }
}