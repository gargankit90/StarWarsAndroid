package com.androidapps.starwars.character

import android.arch.paging.PagedList
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by ankit on 8/17/18.
 */

class CharacterBoundaryCallback(
        private val characterApi: CharacterApi,
        private val characterRepository: CharacterRepositoryImpl,
        private val compositeDisposable: CompositeDisposable
) : PagedList.BoundaryCallback<Character>() {

    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = 1

    /**
     * Database returned 0 items. We should query the backend for more items.
     */
    override fun onZeroItemsLoaded() {
        Log.d("BoundaryCallback", "onZeroItemsLoaded")
        requestAndSave()
    }

    /**
     * User reached to the end of the list.
     */
    override fun onItemAtEndLoaded(itemAtEnd: Character) {
        Log.d("BoundaryCallback", "onItemAtEndLoaded")
        requestAndSave()
    }

    private fun requestAndSave() {
        Log.d("BoundaryCallback", "requestAndSave")
        if (lastRequestedPage == -1) {
            Log.d("BoundaryCallback", "requestAndSave last Page reached")
            return
        }
        compositeDisposable.add(characterApi.getAllCharacters(lastRequestedPage.toString())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    characterRepository.characterDao.insertListOfCharacters(it.characterList)
                    if (it.next != null) {
                        val indexOfEqual = it.next.indexOf("=")
                        if (indexOfEqual > 0) {
                            // url is "https://swapi.co/api/people/1/"
                            // second last element would be the id.
                            lastRequestedPage = it.next.substring(indexOfEqual + 1, it.next.length).toInt()
                        } else {
                            lastRequestedPage = -1
                        }
                    }
                })
    }
}