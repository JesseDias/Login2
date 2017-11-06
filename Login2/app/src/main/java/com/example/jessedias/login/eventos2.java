package com.example.jessedias.login;

import android.util.Log;

/**
 * Created by jessedias on 24/10/2017.
 */

public class eventos2 {

    final String descricao;

    public eventos2(String descricao){


        this.descricao=descricao;


        Log.d("NomeD",descricao);
    }

    public  String getDescricao(){
        return descricao;
    }


}
