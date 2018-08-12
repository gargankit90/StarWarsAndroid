package com.androidapps.starwars.dagger.module;

import com.androidapps.starwars.character.CharacterFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract CharacterFragment contributeCharacterFragment();
}

