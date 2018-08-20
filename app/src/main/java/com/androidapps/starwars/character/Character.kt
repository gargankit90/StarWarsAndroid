package com.androidapps.starwars.character

/**
 * Created by ankit on 8/11/18.
 */
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "character")
data class Character(
        var name: String = "",
        var height: String = "",
        var mass: String = "",
        var hairColor: String = "",
        var skinColor: String = "",
        var eyeColor: String = "",
        var birthYear: String = "",
        var gender: String = "",
        var homeworld: String = "",
        @Ignore
        var films: List<String> = ArrayList(),
        @Ignore
        var species: List<String> = ArrayList(),
        @Ignore
        var vehicles: List<String> = ArrayList(),
        @Ignore
        var starships: List<String> = ArrayList(),
        var created: String = "",
        var edited: String = "",
        var url: String = ""
) {
    @PrimaryKey
    var id: String = ""
        set(value) {
            if (value != "") {
                val arrayOfPath = value.split("/")
                if (arrayOfPath.size > 1) {
                    // url is "https://swapi.co/api/people/1/"
                    // second last element would be the id.
                    field = arrayOfPath[arrayOfPath.size - 2]
                }

            }
        }
}


