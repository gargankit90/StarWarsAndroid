package com.androidapps.starwars.character

import com.androidapps.starwars.shared.StarWarsDb
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by ankit on 8/11/18.
 */

@Singleton
class CharacterRepository @Inject constructor(
                          val characterApi: CharacterApi,
                          val characterDao: CharacterDao,
                          val starWarsDb: StarWarsDb) {
// TODO: Create interaface and an implementation
    fun loadCharacters() : Observable<AllCharacterResponse> {
        return characterApi.getAllCharacters()
    }
}