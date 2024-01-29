/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.entidades;

/**
 *
 * @author yokra
 */
public class TipoVehiculo {
    private static int idNext = 1;
    private int idTipoVehiculo;
    private String descripcion;

    public TipoVehiculo() {
    }
    
    public TipoVehiculo(String descripcion){
        this.idTipoVehiculo = idNext++;
        this.descripcion = descripcion;
    }
    
    public void setIdTipoVehiculo(int idTipoVehiculo){
        this.idTipoVehiculo = idTipoVehiculo;
    }
    public int getIdTipoVehiculo(){
        return idTipoVehiculo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public static int getNextId(){
        return idNext++;
    }
}
