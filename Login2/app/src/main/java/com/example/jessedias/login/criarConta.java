package com.example.jessedias.login;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class criarConta extends AppCompatActivity {

    private FirebaseAuth minhaAuth2;
    private FirebaseAuth.AuthStateListener minhaAuthListener;
    public EditText campoNome2, campoEmail2, campoSenha2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        campoEmail2 = (EditText) findViewById(R.id.email2);
        campoNome2 = (EditText) findViewById(R.id.nome);
        campoSenha2 = (EditText) findViewById(R.id.senha2);
        minhaAuth2 = FirebaseAuth.getInstance();


    }

    public void clica (View view) {

        switch (view.getId()) {
            case R.id.nome:
                campoNome2.setText("");

            if (campoEmail2.getText().toString().trim().equals("")) {

                campoEmail2.setText("email");


            } else if (campoSenha2.getText().toString().trim().equals("")) {

                alertaresultado();

            }
                    break;

            case R.id.email2:
                campoEmail2.setText("");

                if (campoNome2.getText().toString().trim().equals("")) {
                    campoNome2.setText("nome");

                } else if (campoSenha2.getText().toString().trim().equals("")) {

                    alertaresultado();

                }
                break;
            case R.id.senha2:

                campoSenha2.setText("");

                if (campoNome2.getText().toString().trim().equals("")) {
                    campoNome2.setText("nome");

                } else if (campoEmail2.getText().toString().trim().equals("")) {

                    campoEmail2.setText("email");

                }
                break;
        }
    }



    public void criarContaUsuario (View view) {
        minhaAuth2.createUserWithEmailAndPassword(campoEmail2.getText().toString(), campoSenha2.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Log.d("meuLog2", "falha na criação de conta");

                        } else if (task.isSuccessful()){
                            Log.d("meuLog2","criada com sucesso");
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference ref = database.getReference("users").child(FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid());
                            ref.child("nome").setValue(campoNome2.getText().toString());
                            ref.child("uid").setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
                        }
                    }
                });
    }

    public void alertaresultado(){
        AlertDialog alertadialog;
        alertadialog = new AlertDialog.Builder(this).create();
        alertadialog.setMessage("vc nao digitou sua senha");
        alertadialog.show();
    }


}
