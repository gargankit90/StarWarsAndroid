package com.androidapps.starwars.character

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.androidapps.starwars.R
import kotlinx.android.synthetic.main.item_character.view.*

/**
 * Created by ankit on 8/11/18.
 */

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var characterName: TextView = itemView.findViewById(R.id.characterName)

    fun bind(character: Character) {
        characterName.text = character.name
    }

}
