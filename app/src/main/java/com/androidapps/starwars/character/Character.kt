package com.androidapps.starwars.character

/**
 * Created by ankit on 8/11/18.
 */
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "character")
data class Character(
        @Expose
        var name: String = "",
        @Expose
        var height: String = "",
        @Expose
        var mass: String = "",
        @Expose
        var hairColor: String = "",
        @Expose
        var skinColor: String = "",
        @Expose
        var eyeColor: String = "",
        @Expose
        var birthYear: String = "",
        @Expose
        var gender: String = "",
        @Expose
        var homeworld: String = "",
        @Expose
        @Ignore
        var films: List<String> = ArrayList(),
        @Expose
        @Ignore
        var species: List<String> = ArrayList(),
        @Expose
        @Ignore
        var vehicles: List<String> = ArrayList(),
        @Expose
        @Ignore
        var starships: List<String> = ArrayList(),
        @Expose
        var created: String = "",
        @Expose
        var edited: String = "",
        @Expose
        var url: String = ""
) {
    @PrimaryKey
    var id: String = ""
        set(value) {
            if (value != "") {
                val arrayOfPath = value.split("/")
                if (arrayOfPath.size > 0) {
                    // url is "https://swapi.co/api/people/1/"
                    // second last element would be the id.
                    field = arrayOfPath[arrayOfPath.size - 2]
                }

            }
        }
}


