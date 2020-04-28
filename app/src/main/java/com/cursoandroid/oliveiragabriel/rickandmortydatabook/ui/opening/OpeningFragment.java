package com.cursoandroid.oliveiragabriel.rickandmortydatabook.ui.opening;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.activity.VideoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpeningFragment extends Fragment {


    private ImageView btn_play;

    public OpeningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_opening, container, false);

        btn_play = view.findViewById(R.id.btn_play);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), VideoActivity.class));
            }
        });





        return view;
    }



}
