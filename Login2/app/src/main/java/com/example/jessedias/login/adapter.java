package com.example.jessedias.login;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by jessedias on 18/10/2017.
 */

public class adapter extends RecyclerView.Adapter{


    private List<eventos> listaEnvento;
    private Context context;

    public adapter(List<eventos> listaEvento, Context context) {
        this.listaEnvento=listaEvento;

        this.context=context;

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.main_linear_view, parent, false);
       NossoViewHolder holder = new NossoViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        NossoViewHolder holder = (NossoViewHolder) viewHolder;
        eventos listaEventoss = listaEnvento.get(position);

        Log.d("NomeD2",listaEnvento.toString());
        holder.txtNome.setText(listaEventoss.getNome());
        holder.txtDescricao.setText(listaEventoss.getDescricao());



    }


    @Override
    public int getItemCount() {
        return listaEnvento.size();
    }
}
