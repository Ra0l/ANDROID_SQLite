package com.raul.sqlite.POJOS;

import android.content.ContentValues;

import com.raul.sqlite.SQLconstants;

public class Usuario {

    private String id;
    private String nombre;
    private int edad;
    private String correo;

    public Usuario(String id, String nombre, int edad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public Usuario() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                '}';
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(4);
        contentValues.put(SQLconstants.COLUMN_ID,id);
        contentValues.put(SQLconstants.COLUMN_NOMBRE,nombre);
        contentValues.put(SQLconstants.COLUMN_EDAD,edad);
        contentValues.put(SQLconstants.COLUMN_CORREO,correo);

         return contentValues;
    }
}
