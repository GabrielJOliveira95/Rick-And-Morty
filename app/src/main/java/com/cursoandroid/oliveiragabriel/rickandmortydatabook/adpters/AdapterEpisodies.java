package com.cursoandroid.oliveiragabriel.rickandmortydatabook.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.episodiesmodel.Result;

import java.util.List;

public class AdapterEpisodies extends RecyclerView.Adapter<AdapterEpisodies.MyViewHolderEpisodie> {

    private List<Result> list;
    private Context context;

    public AdapterEpisodies(List<Result> list, Context context) {
        this.list = list;
        this.context = context;

    }

    public void addEpisodies(List<Result> list){

        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MyViewHolderEpisodie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.episodies_layout, parent, false);


        return new MyViewHolderEpisodie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEpisodie holder, int position) {

        holder.txt_name_episodie.setText(list.get(position).getName());
        holder.txt_air_date.setText(list.get(position).getAir_date());
        holder.txt_episodie.setText(list.get(position).getEpisode());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolderEpisodie extends RecyclerView.ViewHolder{

        private TextView txt_name_episodie;
        private TextView txt_air_date;
        private TextView txt_episodie;

        public MyViewHolderEpisodie(@NonNull View itemView) {
            super(itemView);

            txt_name_episodie = itemView.findViewById(R.id.txt_name_episodie);
            txt_air_date = itemView.findViewById(R.id.txt_air_date);
            txt_episodie = itemView.findViewById(R.id.txt_episodie);

        }
    }



    public List<Result> getList() {
        return list;
    }

    public void setList(List<Result> list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }




}
