package com.plumbaria.e_10_10_ejemplofirebase2.modelo;

public class Estudiante {
    private String dni;
    private String nombre_completo;
    private int edad;
    private String beca;

    public Estudiante() {
    }

    public String getId() {
        return dni;
    }

    public void setId(String id) {
        this.dni = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    @Override
    public String toString() {
        return "Estudiante: \n" +
                " dni=" + dni + "\n" +
                " nombre_completo=" + nombre_completo + "\n" +
                " edad=" + edad + "\n" +
                " beca=" + beca + "\n";
    }
}