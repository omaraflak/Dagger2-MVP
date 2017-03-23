package me.aflak.dagger2_mvp.data.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Omar on 16/02/2017.
 */

public class ObjectManager {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public ObjectManager(SharedPreferences sharedPreferences, Gson gson){
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void save(Object o, String key){
        sharedPreferences.edit()
                .putString(key, gson.toJson(o))
                .apply();
    }

    public <T> Object get(String key, Class<T> type){
        return gson.fromJson(sharedPreferences.getString(key, null), type);
    }
}
