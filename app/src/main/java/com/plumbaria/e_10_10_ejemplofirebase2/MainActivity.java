package com.plumbaria.e_10_10_ejemplofirebase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
//import de google firebase
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
//nuestra clase estudiante
import com.plumbaria.e_10_10_ejemplofirebase2.modelo.Estudiante;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textview = (TextView)findViewById(R.id.textview);
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        //apuntamos al nodo que queremos leer
        DatabaseReference myRef = fdb.getReference("Estudiante");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                //leeremos un objeto de tipo Estudiante
                GenericTypeIndicator<Estudiante> t = new GenericTypeIndicator<Estudiante>() {};
                Estudiante estudiante = dataSnapshot.getValue(t);
                //formamos el resultado en un string
                String resultado = "Como objeto java:\n\n";
                resultado += estudiante + "\n";
                resultado += "Propiedad Estudiante:\nNombre completo:" +estudiante.getNombre_completo();
                //Tambien podemos leer los datos como un string
                resultado += "\n\n-----------------------------\n\n";
                resultado += "Como JSON:\n\n";
                resultado += dataSnapshot.getValue().toString();
                resultado += "\n\nHijo de Estudiante -> nombre_completo\n";
                resultado += dataSnapshot.child("nombre_completo").toString()+"\n";
                //leemos un nodo hijo del nodo estudiante
                resultado += "\n Key: " + dataSnapshot.child("nombre_completo").getKey()+"\n";
                resultado += "\n Valor: " + dataSnapshot.child("nombre_completo").getValue(String.class);
                //mostramos en el textview
                textview.setText(resultado);
            }
            @Override
            public void onCancelled(DatabaseError error){
                Log.e("ERROR FIREBASE",error.getMessage());
            }
        });
    }
}