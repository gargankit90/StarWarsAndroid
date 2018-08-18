package com.androidapps.starwars.character

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by ankit on 8/11/18.
 */

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListOfCharacters(characters:List<Character>)

    @Query("SELECT * FROM character")
    fun getAllCharacters(): DataSource.Factory<Int, Character>

}