package com.cursoandroid.oliveiragabriel.rickandmortydatabook.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutFragment extends Fragment {

    private TextView linkedln_contact;
    private TextView github_contact;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        String desc = "This application was developed only to be used as a study and portfolio.";
        Element versionElement = new Element();
        versionElement.setTitle("1.0");



        View view = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(desc)
                .addGroup("Contact")
                .addEmail("gabrieljoliveira95@gmail.com", "E-mail")

                .addGroup("Social Medias")
                .addGitHub("GabrielJOliveira95", "GitHub")
                .addWebsite("https://www.linkedin.com/in/gabriel-jesus-de-oliveira-b2b779177/", "Linkedln")

                .addGroup("About Version")
                .addItem(versionElement)
                

                .create();


        return view;
    }
}