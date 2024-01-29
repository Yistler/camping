/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.entidades;

/**
 *
 * @author yokra
 */
public class Representante {
    private String rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    
    public Representante(){
    }
    
    public Representante(String rut, String nombres, String apellidos, String telefono){
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }
    public String getRut(){
        return rut;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public String getNombres(){
        return nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getTelefono(){
        return telefono;
    }
}
