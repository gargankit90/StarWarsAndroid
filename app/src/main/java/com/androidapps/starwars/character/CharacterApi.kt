package com.androidapps.starwars.character

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ankit on 8/11/18.
 */

interface CharacterApi {
    @GET("people/")
    fun getAllCharacters(@Query("page") page:String): Observable<AllCharacterResponse>
}