package com.example.jessedias.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class listaEventos extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference();

    FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    StorageReference storageReference;


    private ChildEventListener childEventListener;
    FirebaseUser user;

private  String Nome;
    private Object meuNome;
    private String meuNome2;
    private String descricao ;
    private String imagem;
    private String meuUid;

    private ArrayList listaNomes;

    private ArrayList lista;

    private TextView nome;
    private TextView descricao2;

    private ImageView minhaImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);

        lista  =   new ArrayList<>();
        listaNomes=new ArrayList<>();

        nome=(TextView) findViewById(R.id.nome );
        descricao2=(TextView) findViewById(R.id.descricao);
        minhaImagem=(ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String amor = bundle.getString("evento");
        Log.d("simpsons",amor);



       reference.child("simpsons").child(amor).addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               meuNome=dataSnapshot.child("nome").getValue(String.class);
               descricao=dataSnapshot.child("descrição").getValue(String.class);
               imagem=dataSnapshot.child("foto").getValue(String.class);
               Log.d("amor",meuNome.toString());
               Log.d("amor",descricao.toString());
               Log.d("amor",imagem.toString());
               nome.setText(meuNome.toString());
               descricao2.setText(descricao);



               Picasso.with(getApplicationContext()).load(imagem).into(minhaImagem);

               /*Glide.with(getApplicationContext()).using(new FirebaseImageLoader())
                       .load(storageReference)
                       .into(minhaImagem);*/


           }
               @Override
               public void onCancelled (DatabaseError databaseError){

               }



       });




            }




}

