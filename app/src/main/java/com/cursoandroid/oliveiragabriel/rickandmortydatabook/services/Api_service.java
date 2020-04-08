package com.cursoandroid.oliveiragabriel.rickandmortydatabook.services;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.localizationmodel.RootObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_service {



    @GET("api/character")
    Call<com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.personagensmodels.RootObject> getCharacter(@Query("page") int page);

    @GET("api/location")
    Call<RootObject> getLocalization(@Query("page") int page);


}
