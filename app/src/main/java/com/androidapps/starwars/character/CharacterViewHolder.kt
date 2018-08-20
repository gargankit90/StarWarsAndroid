package com.androidapps.starwars.character

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.androidapps.starwars.R
import com.androidapps.starwars.shared.CHARCTER_IMAGE_URL
import com.squareup.picasso.Picasso

/**
 * Created by ankit on 8/11/18.
 */

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var characterName: TextView = itemView.findViewById(R.id.characterName)
    private var characterHeight: TextView = itemView.findViewById(R.id.characterHeight)
    private var characterBirthYear:TextView = itemView.findViewById(R.id.characterBirthYear)
    private var characterImage:ImageView = itemView.findViewById(R.id.characterImage)

    fun bind(character: Character) {
        characterName.text = character.name
        characterHeight.text = character.height
        characterBirthYear.text = character.birthYear
        val urlImage:String = CHARCTER_IMAGE_URL + getImagePath(character.url)
        // TODO: Add placeholder and error images
        Picasso.get().load(urlImage).into(characterImage)
    }

    fun getImagePath(url:String): String {
        // This is how URL looks
        // "https://swapi.co/api/people/1/"
        // We need to extract id from URL
        // Image Url looks like this
        // https://starwars-visualguide.com/assets/img/characters/1.jpg
        val pathArray = url.split("/")
        var imagePath:String = ""
        if (pathArray.size > 5) {
            imagePath = pathArray[5] + ".jpg"
        }
        return imagePath
    }
}
