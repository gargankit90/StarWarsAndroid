package com.androidapps.starwars.character

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androidapps.starwars.R

/**
 * Created by ankit on 8/11/18.
 */

class CharacterAdapter(var characterList: List<Character>): RecyclerView.Adapter<CharacterViewHolder>() {
    //TODO: Implement ListAdapter DiffUtil functionality

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount() = characterList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList.get(position))
    }
}
