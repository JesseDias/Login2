package com.example.jessedias.login;

import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by jessedias on 18/10/2017.
 */

public class eventos {

    private final String nome;
    private final String descricao;

    public eventos(String nome, String descricao) {

        this.nome = nome;
        this.descricao=descricao;

        Log.d("NomeDes", nome);
        Log.d("NomeDes",descricao);
    }


    public String getNome() {
        return nome;



    }
    public String getDescricao(){
        return descricao;
    }


    }






