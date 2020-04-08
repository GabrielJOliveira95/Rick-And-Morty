package com.cursoandroid.oliveiragabriel.rickandmortydatabook.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;

import java.util.List;

public class AdapterNome extends RecyclerView.Adapter<AdapterNome.MyViewHolder2> {

    private List<String> list;
    private Context context;

    public AdapterNome(List<String> list){

        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2, parent, false);

        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

        holder.nome.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        private TextView nome;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
        }
    }
}
