package com.example.muebleria;

// Clase para representar cada cliente
public class Cliente {
    public String nombre;
    public String correo;
    public String telefono;
    public int edad;

    public Cliente(String nombre, String correo, String telefono, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
    }
}

