package com.androidapps.starwars.character

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ankit on 8/11/18.
 */

data class AllCharacterResponse(
        @SerializedName("count")
        @Expose
        val count: kotlin.Int,
        @SerializedName("next")
        @Expose
        val next: String,
        @SerializedName("previous")
        @Expose
        val previous: Any,
        @SerializedName("results")
        @Expose
        val characterList: List<Character>)


