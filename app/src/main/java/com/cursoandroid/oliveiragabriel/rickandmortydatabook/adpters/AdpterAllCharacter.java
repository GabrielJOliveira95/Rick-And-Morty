package com.cursoandroid.oliveiragabriel.rickandmortydatabook.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.personagensmodels.Result;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdpterAllCharacter extends RecyclerView.Adapter<AdpterAllCharacter.MyViewHolder> {



    private List<Result> result;
    private Context context;


    public void addCharacter(List<Result> list) {

        result.addAll(list);
        notifyDataSetChanged();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageView;
        private TextView txt_name;
        private TextView txt_status;
        private TextView txt_specie;
        private TextView txt_gender;
        private TextView txt_origin;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile);
            txt_name =  itemView.findViewById(R.id.txt_name);
            txt_gender = itemView.findViewById(R.id.txt_gender);
            txt_origin = itemView.findViewById(R.id.txt_origin);
            txt_status = itemView.findViewById(R.id.txt_status);
            txt_specie = itemView.findViewById(R.id.txt_specie);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_personangens, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txt_name.setText(result.get(position).getName());
        holder.txt_specie.setText(result.get(position).getSpecies());
        holder.txt_status.setText(result.get(position).getStatus());
        holder.txt_gender.setText(result.get(position).getGender());
        holder.txt_origin.setText(result.get(position).getOrigin().getName());
        Picasso.with(context).load(result.get(position).getImage()).resize(400, 400).centerCrop().into(holder.imageView);


    }

    @Override
    public int getItemCount() {

        return result.size();
    }

    //Construtores e get and set


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public AdpterAllCharacter(List<Result> rootObject, Context context){

        this.result = rootObject;
        this.context = context;
    }



    public void searchCharacter(List<Result> list){

        this.result = new ArrayList<>();
        result.addAll(list);
        notifyDataSetChanged();
    }


}
