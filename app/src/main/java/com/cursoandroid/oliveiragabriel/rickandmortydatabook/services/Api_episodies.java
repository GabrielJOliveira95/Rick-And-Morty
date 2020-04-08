package com.cursoandroid.oliveiragabriel.rickandmortydatabook.services;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.episodiesmodel.RootObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_episodies {

    @GET("api/episode")
    Call<RootObject> getEpisodies(@Query("page") int page);
}
