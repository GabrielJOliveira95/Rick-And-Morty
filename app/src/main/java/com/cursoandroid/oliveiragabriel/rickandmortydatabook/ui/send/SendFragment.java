package com.cursoandroid.oliveiragabriel.rickandmortydatabook.ui.send;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;

public class SendFragment extends Fragment {

    private TextView linkedln_contact;
    private TextView github_contact;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_send, container, false);

        linkedln_contact = view.findViewById(R.id.linkedln_contact);
        github_contact   = view.findViewById(R.id.github_contact);


        Linkify.addLinks(github_contact, Linkify.WEB_URLS);
        Linkify.addLinks(linkedln_contact, Linkify.WEB_URLS);


        /*whatsapp_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+55(11)95903-6882";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                startActivity(intent);
            }
        });*/






        return view;
    }
}