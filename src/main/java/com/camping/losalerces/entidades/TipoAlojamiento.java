/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.entidades;

/**
 *
 * @author yokra
 */
public class TipoAlojamiento {
    private static int nextId = 1;
    private int idTipoAlojamiento;
    private String descripcion;

    public TipoAlojamiento() {
    }

    public TipoAlojamiento(String descripcion) {
        this.idTipoAlojamiento = nextId++;
        this.descripcion = descripcion;
    }

    public int getIdTipoAlojamiento() {
        return idTipoAlojamiento;
    }

    public void setIdTipoAlojamiento(int idTipoAlojamiento) {
        this.idTipoAlojamiento = idTipoAlojamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public static int getNextId(){
        return nextId++;
    }
    
}
