package com.androidapps.starwars.character

import com.androidapps.starwars.shared.StarWarsDb
import io.reactivex.Observable
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

    override fun loadCharacters(): Observable<AllCharacterResponse> {
        return characterApi.getAllCharacters()
    }
}

interface CharacterRepository {
    fun loadCharacters(): Observable<AllCharacterResponse>
}