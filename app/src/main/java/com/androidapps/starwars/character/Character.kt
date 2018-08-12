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
        @SerializedName("name")
        @Expose
        var name: String = "",
        @SerializedName("height")
        @Expose
        var height: String = "",
        @SerializedName("mass")
        @Expose
        var mass: String = "",
        @SerializedName("hair_color")
        @Expose
        var hairColor: String = "",
        @SerializedName("skin_color")
        @Expose
        var skinColor: String = "",
        @SerializedName("eye_color")
        @Expose
        var eyeColor: String = "",
        @SerializedName("birth_year")
        @Expose
        var birthYear: String = "",
        @SerializedName("gender")
        @Expose
        var gender: String = "",
        @SerializedName("homeworld")
        @Expose
        var homeworld: String = "",
        @SerializedName("films")
        @Expose
        @Ignore
        var films: List<String> = ArrayList(),
        @SerializedName("species")
        @Expose
        @Ignore
        var species: List<String> = ArrayList(),
        @SerializedName("vehicles")
        @Expose
        @Ignore
        var vehicles: List<String> = ArrayList(),
        @SerializedName("starships")
        @Expose
        @Ignore
        var starships: List<String> = ArrayList(),
        @SerializedName("created")
        @Expose
        var created: String = "",
        @SerializedName("edited")
        @Expose
        var edited: String = "",
        @SerializedName("url")
        @Expose
        @PrimaryKey
        var url: String = ""
)


