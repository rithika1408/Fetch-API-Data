package com.example.asiacountries;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Model> model;
    private Context context;

    public RecyclerAdapter(List<Model> model){

        this.model=model;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View inflate= layoutInflater.inflate(R.layout.view,null);
        ViewHolder viewHolder=new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model data=model.get(position);
        holder.name.setText(data.getName());
        //Picasso.get().load(data.getFlag()).into(holder.flag);
        Glide.with(holder.name.getContext()).load(data.getFlag()).into(holder.flag);


        for(int i=0;i<data.getBorder().size();i++){
            if(data.getBorder().size()-1!=i)
                holder.borders.append(data.getBorder().get(i)+',');
            else
                holder.borders.append(data.getBorder().get(i));
        }

        holder.capital.setText(data.getCapital());
        holder.region.setText(data.getRegion());
        holder.subregion.setText(data.getSubRegion());
        holder.population.setText(data.getPopulation());







    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView flag;
        TextView capital;
        TextView region;
        TextView subregion;
        TextView population;
        TextView borders;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            flag=itemView.findViewById(R.id.flag);
            capital=itemView.findViewById(R.id.textView1);
            region=itemView.findViewById(R.id.textView2);
            subregion=itemView.findViewById(R.id.textView3);
            population=itemView.findViewById(R.id.textView4);
            borders=itemView.findViewById(R.id.textView5);

        }
    }
}
