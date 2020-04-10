package com.cursoandroid.oliveiragabriel.rickandmortydatabook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;

public class HomeFragment extends Fragment {


    private ViewFlipper viewFlipper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        int image[] = {R.drawable.fundo0, R.drawable.fundo1jpg, R.drawable.fundo2jpg, R.drawable.fundo3jpg, R.drawable.fundo4jpg, R.drawable.fundo5};
        viewFlipper = view.findViewById(R.id.viewflipper);


        for (int item: image){

            flipperView(item);
        }

        return view;
    }

    public void flipperView(int image){

        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }

}