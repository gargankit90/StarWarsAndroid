package com.androidapps.starwars.dagger.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.androidapps.starwars.character.CharacterViewModel;
import com.androidapps.starwars.dagger.ViewModelFactory;
import com.androidapps.starwars.dagger.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Ankit Garg on 10/29/17.
 */

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel.class)
    abstract ViewModel bindCharacterViewModel(CharacterViewModel characterViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
