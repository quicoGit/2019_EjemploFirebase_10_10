package com.plumbaria.e_10_10_ejemplofirebase2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
//import de google firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener
//nuestra clase estudiante
import com.plumbaria.e_10_10_ejemplofirebase2.modelo.Estudiante

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview = findViewById<View>(R.id.textview) as TextView
        val fdb = FirebaseDatabase.getInstance()
        //apuntamos al nodo que queremos leer
        val myRef = fdb.getReference("Estudiante")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //leeremos un objeto de tipo Estudiante
                val t = object : GenericTypeIndicator<Estudiante>() {

                }
                val estudiante = dataSnapshot.getValue(t)
                //formamos el resultado en un string
                var resultado = "Como objeto java:\n\n"
                resultado += estudiante!!.toString() + "\n"
                resultado += "Propiedad Estudiante:\nNombre completo:" + estudiante.nombre_completo
                //Tambien podemos leer los datos como un string
                resultado += "\n\n-----------------------------\n\n"
                resultado += "Como JSON:\n\n"
                resultado += dataSnapshot.value!!.toString()
                resultado += "\n\nHijo de Estudiante -> nombre_completo\n"
                resultado += dataSnapshot.child("nombre_completo").toString() + "\n"
                //leemos un nodo hijo del nodo estudiante
                resultado += "\n Key: " + dataSnapshot.child("nombre_completo").key + "\n"
                resultado += "\n Valor: " + dataSnapshot.child("nombre_completo").getValue<String>(String::class.java!!)!!
                //mostramos en el textview
                textview.text = resultado
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ERROR FIREBASE", error.message)
            }
        })
    }
}