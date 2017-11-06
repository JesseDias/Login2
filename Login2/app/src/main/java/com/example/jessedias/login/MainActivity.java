package com.example.jessedias.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth minhaAuth;
    private FirebaseAuth.AuthStateListener minhaAuthListener;



    private EditText campoEmail, campoSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        campoEmail = (EditText) findViewById(R.id.email);


        campoSenha = (EditText) findViewById(R.id.senha);
        minhaAuth = FirebaseAuth.getInstance();

        minhaAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d("meuLog", "usuario conectado" + user.getUid());
                    Intent i = new Intent(getApplicationContext(),RecycleView.class);
                    startActivity(i);
                } else {
                    Log.d("meuLog", "Sem usuarios conectados");

                }
            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        minhaAuth.addAuthStateListener(minhaAuthListener);
    }

    @Override

    public void onStop() {
        super.onStop();
        if (minhaAuthListener != null) {
            minhaAuth.removeAuthStateListener(minhaAuthListener);
        }
    }

    public void clicaLogin(View view) {
        minhaAuth.signInWithEmailAndPassword(campoEmail.getText().toString(), campoSenha.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Log.d("meuLog", "falha na autenticação");

                        }

                    }
                });
    }

    public void criar(View view) {

        Intent j = new Intent(getApplicationContext(), criarConta.class);
        startActivity(j);


    }



}

