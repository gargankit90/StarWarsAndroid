package com.androidapps.starwars.dagger.component;

import com.androidapps.starwars.character.CharacterViewModel;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels. It is called by the
 * Using this component allows
 * ViewModels to define {@link javax.inject.Inject} constructors.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    CharacterViewModel characterViewModel();
}
