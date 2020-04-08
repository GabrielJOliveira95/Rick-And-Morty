package com.cursoandroid.oliveiragabriel.rickandmortydatabook.ui.localization;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.adpters.AdapterLocalization;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.localizationmodel.Result;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.localizationmodel.RootObject;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.services.Api_service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalizationFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Result> list = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;
    private boolean carregar;
    private int page;
    private Retrofit retrofit;
    private AdapterLocalization adapterLocalization;

    public LocalizationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_localization, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_localization);
        page = 1;


        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapterLocalization = new AdapterLocalization(list, getActivity());
        recyclerView.setAdapter(adapterLocalization);
        recyclerView.hasFixedSize();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0){

                    int visibleItemCount = gridLayoutManager.getChildCount();
                    int totalItemCount = gridLayoutManager.getItemCount();
                    int pastVisibleItens = gridLayoutManager.findFirstVisibleItemPosition();

                    if (carregar){
                        if ((visibleItemCount + pastVisibleItens) >= totalItemCount){

                            carregar = false;
                            page += 1;
                            getTypeOfList(page);

                        }
                    }
                }
            }
        });

        carregar = true;
        getTypeOfList(page);



        return view;
    }



    public void getTypeOfList(int page){

        Api_service api_service = retrofit.create(Api_service.class);
        Call<RootObject> rootObjectCall = api_service.getLocalization(page);
        rootObjectCall.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                carregar = true;

                if (response.isSuccessful()){

                    RootObject rootObject = response.body();
                    list = rootObject.getResults();

                    adapterLocalization.addLocalization(list);



                }

            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {
                carregar = true;

            }
        });



    }

}
