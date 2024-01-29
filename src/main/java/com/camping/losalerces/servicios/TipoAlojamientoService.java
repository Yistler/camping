/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.servicios;

import com.camping.losalerces.entidades.TipoAlojamiento;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author yokra
 */
@Path("/tipoAlojamientos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoAlojamientoService {
    public static final List<TipoAlojamiento> alojamientos = new ArrayList<>();
    static{
        alojamientos.add(new TipoAlojamiento("cabaña grande 6 habitaciones"));
        alojamientos.add(new TipoAlojamiento("cabaña mediana 3 habitaciones"));
        alojamientos.add(new TipoAlojamiento("cabaña pequeña 1 habitacion"));
    }
    @GET
    public Response consultarTipoAlojamiento(){
        Gson gson = new Gson();
        String alojamiento = gson.toJson(alojamientos);
        return Response.status(200).entity(alojamiento).build();
    }
    
    @POST
    @Path("/agregar")
    public Response agregarTipoAlojamiento(TipoAlojamiento tipoAlojamiento){
        //serializo tipoAlojamiento
        Gson gson = new Gson();
        String gsonString = gson.toJson(tipoAlojamiento);
        //descerealizo tipoAlojamiento
        TipoAlojamiento tipoAlojamientoEntidad = gson.fromJson(gsonString, TipoAlojamiento.class);
        
        //le asigno el siguiente id al tipoAlojamiento que se desea agregar
        tipoAlojamientoEntidad.setIdTipoAlojamiento(TipoAlojamiento.getNextId());
        
        //agrego el tipoAlojamiento a la lista
        alojamientos.add(tipoAlojamientoEntidad);
        
        //serializo a json la lista de alojamientos para poder mostrarla en formato json
        String jsonString = gson.toJson(alojamientos);
        
        //retornar/muestro la lista de alojamientos en formato json
        return Response.status(200).entity(jsonString).build();
    }
    
    
    @PUT
    @Path("/actualizar")
    public Response actualizarAlojamiento(@QueryParam("id")int id, TipoAlojamiento alojamientoRecibido){
        TipoAlojamiento alojamientoActualizar = null;
        for(TipoAlojamiento alojamientoR : alojamientos){
            if(alojamientoR.getIdTipoAlojamiento() == (id)){
                alojamientoActualizar = alojamientoR;
                break;
            }
        }
        if(alojamientoActualizar != null){
            alojamientos.remove(alojamientoActualizar);
            alojamientos.add(alojamientoRecibido);
            Gson gson = new Gson();
            String gsonString = gson.toJson(alojamientos);
            return Response.status(200).entity(gsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Alojamiento no encontrado\"}").build();
        }
    }
    
    
    @DELETE
    @Path("/eliminar")
    public Response eliminarAlojamiento(@QueryParam("id") int id){
        //Aqui implementar la logica para eliminar un usuario de la lista
        Gson gson = new Gson();
        
        TipoAlojamiento alojamientoEliminar = null;
        for(TipoAlojamiento alojamientoR : alojamientos){
            if(alojamientoR.getIdTipoAlojamiento() == (id)){
                alojamientoEliminar = alojamientoR;
                break;
            }
        }
        if(alojamientoEliminar != null){
            alojamientos.remove(alojamientoEliminar);
            String jsonString = gson.toJson(alojamientos);
            return Response.status(200).entity(jsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Alojamiento no encontrado\"}").build();
        }
    }
}
