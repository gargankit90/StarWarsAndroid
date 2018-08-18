package com.androidapps.starwars.character

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidapps.starwars.R
import com.androidapps.starwars.dagger.utility.Injectable
import kotlinx.android.synthetic.main.fragment_character.*
import javax.inject.Inject

class CharacterFragment() : Fragment(), Injectable {
    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var characterViewModel: CharacterViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterViewModel = ViewModelProviders.of(this, viewModelFactory).get(CharacterViewModel::class.java)
        characterAdapter = CharacterAdapter()
        characterList.layoutManager = LinearLayoutManager(context)
        characterList.adapter = characterAdapter
        characterViewModel.loadCharacters()
        characterViewModel.getCharactersLiveData().observe(this, Observer<PagedList<Character>> {characterAdapter.submitList(it)})
    }

    companion object {
        const val TAG = "CharacterFragment"
    }
}
