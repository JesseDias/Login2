package com.example.jessedias.login;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jessedias on 18/10/2017.
 */

public class NossoViewHolder extends RecyclerView.ViewHolder {

    final TextView txtNome;
    final TextView txtDescricao;
    final ImageView fotoImagem;


    public NossoViewHolder (View itemview){
        super(itemview);

        txtNome =(TextView) itemview.findViewById(R.id.tristeza);
        txtDescricao=(TextView) itemview.findViewById(R.id.descricao);
        fotoImagem=(ImageView) itemview.findViewById(R.id.fotoShow);


    }
}
