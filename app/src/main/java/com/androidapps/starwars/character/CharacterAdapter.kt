package com.androidapps.starwars.character

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androidapps.starwars.R

/**
 * Created by ankit on 8/11/18.
 */

class CharacterAdapter(): PagedListAdapter<Character, CharacterViewHolder>(
        object: DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character) = oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Character, newItem: Character) = oldItem == newItem
        }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position)?:Character())
    }
}
