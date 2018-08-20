package com.androidapps.starwars.shared

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.androidapps.starwars.character.Character
import com.androidapps.starwars.character.CharacterDao


/**
 * Created by ankit on 8/11/18.
 */

@Database(entities = [Character::class], version = 1)
abstract class StarWarsDb : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}