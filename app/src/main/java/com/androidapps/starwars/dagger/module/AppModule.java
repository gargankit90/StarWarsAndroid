package com.androidapps.starwars.dagger.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.androidapps.starwars.character.Character;
import com.androidapps.starwars.character.CharacterApi;
import com.androidapps.starwars.character.CharacterDao;
import com.androidapps.starwars.character.CharacterDeserializer;
import com.androidapps.starwars.shared.StarWarsDb;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.androidapps.starwars.shared.ConstantKt.DATABASE_NAME;
import static com.androidapps.starwars.shared.ConstantKt.REST_URL;

@Module(includes = ViewModelModule.class)
public class AppModule {
    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Character.class, new CharacterDeserializer());
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addNetworkInterceptor(new StethoInterceptor());
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    CharacterApi provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(REST_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(CharacterApi.class);
    }

    @Singleton
    @Provides
    StarWarsDb provideDb(Application app) {
        return Room.databaseBuilder(app, StarWarsDb.class, DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    CharacterDao provideCharacterDao(StarWarsDb db) {
        return db.characterDao();
    }

}