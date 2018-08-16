package com.androidapps.starwars.character

import com.google.gson.*
import java.lang.reflect.Type

/**
 * Created by ankit on 8/15/18.
 */

class CharacterDeserializer: JsonDeserializer<Character>{
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Character {
        val jsonObject:JsonObject? = json?.asJsonObject
        val name = jsonObject?.get("name")?.asString?:""
        val height = jsonObject?.get("height")?.asString?:""
        val mass = jsonObject?.get("mass")?.asString?:""
        val hairColor = jsonObject?.get("hair_color")?.asString?:""
        val skinColor = jsonObject?.get("skin_color")?.asString?:""
        val eyeColor = jsonObject?.get("eye_color")?.asString?:""
        val birthYear = jsonObject?.get("birth_year")?.asString?:""
        val gender = jsonObject?.get("gender")?.asString?:""
        val homeWorld = jsonObject?.get("homeworld")?.asString?:""
        val created = jsonObject?.get("created")?.asString?:""
        val edited = jsonObject?.get("edited")?.asString?:""
        val url = jsonObject?.get("url")?.asString?:""
        // Parse films
        val films = jsonObject?.getAsJsonArray("films")
        val filmsList = arrayListOf<String>()
        for (film in films?: JsonArray()) {
            filmsList.add(film?.asString?:"")
        }
        // parse species
        val species = jsonObject?.getAsJsonArray("species")
        val speciesList = arrayListOf<String>()
        for (specie in species?: JsonArray()) {
            speciesList.add(specie?.asString?:"")
        }
        // parse vehicles
        val vehicles = jsonObject?.getAsJsonArray("vehicles")
        val vehiclesList = arrayListOf<String>()
        for (vehicle in vehicles?: JsonArray()) {
            vehiclesList.add(vehicle?.asString?:"")
        }
        // parse starships
        val starships = jsonObject?.getAsJsonArray("starships")
        val starshipsList = arrayListOf<String>()
        for (starship in starships?: JsonArray()) {
            starshipsList.add(starship?.asString?:"")
        }

        val character = Character(
                name,
                height,
                mass,
                hairColor,
                skinColor,
                eyeColor,
                birthYear,
                gender,
                homeWorld,
                filmsList,
                speciesList,
                vehiclesList,
                starshipsList,
                created,
                edited,
                url
        )

        character.id = url
        return character
    }

}