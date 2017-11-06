package com.example.jessedias.login;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class segundaTela extends AppCompatActivity {




    private ArrayAdapter<Object> adaptador;

    private ArrayList usuarios;
    private ArrayList descricao;







    public ListView minhaLista;



    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();



    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    private String meuUid;
    private Object meuNome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        minhaLista = (ListView) findViewById(R.id.lista3);
        //storage = FirebaseStorage.getInstance();
        //storageReference = storage.getReferenceFromUrl("gs://meu-app-2ace4.appspot.com/");



        descricao = new ArrayList<>();
        usuarios = new ArrayList<>();

        adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1,
                usuarios);

        minhaLista.setAdapter(adaptador);




minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.d("meuLog", String.valueOf(id));

            String name = parent.getItemAtPosition(position).toString();
            Log.d("meuX", name);
            Intent h = new Intent(getApplicationContext(), minhaCardView.class);
            Bundle bundle = new Bundle();
            bundle.putString("evento", name);
            h.putExtras(bundle);
            startActivity(h);



    }
});
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    usuarios.add(data.getKey());
                    adaptador.notifyDataSetChanged();

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                usuarios.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    usuarios.add(data.getKey());
                    adaptador.notifyDataSetChanged();

                }
            }


            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    /*
    @Override
    protected void onStart() {
        super.onStart();
        if (user==null){
            finish();
        }


        childEventListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

               if (!dataSnapshot.child("dias").getValue(String.class).equals("nomefinal")){
                   usuarios.add(dataSnapshot.child("jesse").getValue(String.class));
                   adaptador.notifyDataSetChanged();


               }



                /*if (user == null) {
                    finish();
                } else {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        usuarios.add(data.getValue(Object.class));
                        adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1,
                                usuarios);
                        minhaLista.setAdapter(adaptador);

                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


            /*ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        usuarios.add(data.getValue(Object.class));
                    }
                    adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,
                            android.R.id.text1,
                            usuarios);
                    minhaLista.setAdapter(adaptador);
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }*/





    /*
        ref.child("users").child(meuUid).child("nome");
        if (user==null){
            finish();
        } else {

           ref.addChildEventListener(new ChildEventListener() {

               @Override
               public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                   if (!dataSnapshot.child("uid").getValue(String.class).equals(meuUid)) {
                       usuarios.add(dataSnapshot.getChildren());
                       adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,
                               android.R.id.text1,
                               usuarios);
                       minhaLista.setAdapter(adaptador);

                   }
               }

               @Override
               public void onChildChanged(DataSnapshot dataSnapshot, String s) {

               }

               @Override
               public void onChildRemoved(DataSnapshot dataSnapshot) {

               }

               @Override
               public void onChildMoved(DataSnapshot dataSnapshot, String s) {

               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
           });

       }*/


        /*seguindo = new ArrayList<>();
        userIds = new ArrayList<>();
        minhaRecycle = (RecyclerView) findViewById(R.id.recicla);


        //minhaRecycle=(RecyclerView) findViewById(R.id.recicla);





        if (user == null) {
            finish();

        } else {

            Log.d("logMeu","errado aquui doido ");


            ref.child("user").child(meuUid).child("nome");




            userIds.clear();
            usuarios.clear();
            childEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.d("logMeu","errado aquui doido 2");
                    if (!dataSnapshot.child("uid").getValue(String.class).equals(meuUid)) {
                        usuarios.add(dataSnapshot.child("nome").getValue(String.class));
                        userIds.add(dataSnapshot.child("uid").getValue(String.class));
                        adaptador.notifyDataSetChanged();
                        Log.d("meu log", "sguindo,seguindo");
                        atualizarLista();
                    }
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };

            ref.child("users").addChildEventListener(childEventListener);

            valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("logMeu","errado aquui doido 3");
                    seguindo.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Log.d("logMeu","errado aquui doido 4");
                        seguindo.add(data.getValue(Object.class));
                    }
                    Log.d("meuLog", "seguindo: " + seguindo);
                    atualizarLista();

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }


            };

            ref.child("users").child(meuUid).child("seguindo").setValue(valueEventListener);


        }
    }



    /*Glide.with(this)
                        .using(new FirebaseImageLoader())
                        .load(storageRef)
                        .into(minhaImagem);

            }

            public void onCancelled(DatabaseError databaseError) {

            }


        }
    }*/    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.sair) {
            FirebaseAuth.getInstance().signOut();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }



}
