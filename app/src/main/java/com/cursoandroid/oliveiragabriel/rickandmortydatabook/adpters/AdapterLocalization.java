package com.cursoandroid.oliveiragabriel.rickandmortydatabook.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.oliveiragabriel.rickandmortydatabook.R;
import com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.localizationmodel.Result;

import java.util.List;


public class AdapterLocalization extends RecyclerView.Adapter<AdapterLocalization.MyViewHolderLocalization> {

    private Context context;
    private List<Result> list;

    public  AdapterLocalization(List<Result> list, Context context){

        this.list = list;
        this.context = context;

    }

    public void addLocalization(List<Result> list) {

        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MyViewHolderLocalization onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_localization, parent, false);

        return new MyViewHolderLocalization(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderLocalization holder, int position) {

        holder.txt_localization.setText(list.get(position).getName());
        holder.txt_dimension.setText(list.get(position).getDimension());
        holder.txt_type.setText(list.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolderLocalization extends RecyclerView.ViewHolder {
        private TextView txt_localization;
        private TextView txt_type;
        private TextView txt_dimension;

        public MyViewHolderLocalization(@NonNull View itemView) {
            super(itemView);

            txt_localization = itemView.findViewById(R.id.txt_localization);
            txt_type = itemView.findViewById(R.id.txt_type);
            txt_dimension = itemView.findViewById(R.id.txt_dimension);

        }
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Result> getList() {
        return list;
    }

    public void setList(List<Result> list) {
        this.list = list;
    }

}
