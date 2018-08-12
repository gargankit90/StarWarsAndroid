package com.androidapps.starwars.character

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.androidapps.starwars.shared.AbstractViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ankit on 8/11/18.
 */


class CharacterViewModel @Inject constructor(
        val applicationContext:Application,
        val characterRepository: CharacterRepository) : AndroidViewModel(applicationContext) {
        var characters: List<Character> = emptyList()
    fun loadCharacter(): List<Character> {
        characterRepository.loadCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe() {
                    characters = it.characterList
                }
        return characters
    }
}