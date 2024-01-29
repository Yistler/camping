/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.entidades;

import java.io.Serializable;

/**
 *
 * @author yokra
 */
public class Usuarios implements Serializable{
    private String userName;
    private String password;
    private String nombres;
    private String apellidos;
    
    public Usuarios(){   
    }
    
    public Usuarios(String userName, String password, String nombres, String apellidos){
        this.userName = userName;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getNombres(){
        return nombres;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
}

