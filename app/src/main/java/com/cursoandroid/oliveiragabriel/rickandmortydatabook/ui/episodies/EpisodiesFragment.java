package com.cursoandroid.oliveiragabriel.rickandmortydatabook.ui.episodies;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.adpters.AdapterEpisodies;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.episodiesmodel.Result;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.episodiesmodel.RootObject;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.services.Api_episodies;

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
public class EpisodiesFragment extends Fragment {

    private RecyclerView episodies_recyclerview;
    private Retrofit retrofit;
    private List<Result> list = new ArrayList<>();
    private boolean carregar;
    private int page;
    private GridLayoutManager gridLayoutManager;
    AdapterEpisodies adapterEpisodies;
    public EpisodiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_episodies, container, false);
        episodies_recyclerview = view.findViewById(R.id.episodies_recyclerview);
        page = 1;



        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        adapterEpisodies = new AdapterEpisodies(list, getActivity());
        episodies_recyclerview.setAdapter(adapterEpisodies);

        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        episodies_recyclerview.setLayoutManager(gridLayoutManager);
        episodies_recyclerview.hasFixedSize();

        episodies_recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                            getEpisodiesAPI(page);

                        }
                    }
                }
            }
        });
        carregar = true;
        getEpisodiesAPI(page);



        return view;
    }


    public void getEpisodiesAPI(int page){
        Api_episodies api_episodies = retrofit.create(Api_episodies.class);
        Call<RootObject> call = api_episodies.getEpisodies(page);
        call.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                carregar = true;

                if (response.isSuccessful()){

                    RootObject rootObject = response.body();
                    list = rootObject.getResults();
                    adapterEpisodies.addEpisodies(list);


                }


            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {
                carregar = true;

            }
        });
    }

}
