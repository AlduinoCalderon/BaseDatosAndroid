package com.example.basedatos;

public class Materia {
    private int claveMateria;

    public int getClaveMateria() {
        return claveMateria;
    }
    public Materia(int claveMateria, String nombreMateria){
        this.claveMateria = claveMateria;
        this.nombreMateria = nombreMateria;
    }
    public void setClaveMateria(int claveMateria) {
        this.claveMateria = claveMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    private  String nombreMateria;

}
