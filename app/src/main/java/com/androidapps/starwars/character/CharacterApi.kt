package com.androidapps.starwars.character

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ankit on 8/11/18.
 */

interface CharacterApi {
    @GET("people/")
    fun getAllCharacters(): Observable<AllCharacterResponse>
}