/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.servicios;

import com.camping.losalerces.entidades.TipoVehiculo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
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
@Path("/tipoVehiculos")
@Produces(MediaType.APPLICATION_JSON)
public class TipoVehiculoService {
    public static final List<TipoVehiculo> vehiculos = new ArrayList<>();
    static{
        vehiculos.add(new TipoVehiculo("auto aveo 4pt gris"));
        vehiculos.add(new TipoVehiculo("camioneta toyota blanca"));
    }
    @GET
    public Response consultarTipoVehiculo(){
        Gson gson = new Gson();
        String vehiculosJson = gson.toJson(vehiculos);
        return Response.status(200).entity(vehiculosJson).build();
    }
    
    @POST
    @Path("/agregar")
    public Response agregarTipoVehiculo(TipoVehiculo tipoVehiculo){
        //creo una instancia de gson para serializar el parametro recibido en json
        Gson gson = new Gson();
        String gsonString = gson.toJson(tipoVehiculo);
        
        //deserealizo el json y lo paso a entida de java 
        TipoVehiculo tipoVehiculoEntidad = gson.fromJson(gsonString, TipoVehiculo.class);
        tipoVehiculoEntidad.setIdTipoVehiculo(TipoVehiculo.getNextId()); // Asignar el id siguiente

        vehiculos.add(tipoVehiculoEntidad);
        //lo paso nuevamente a json para posterior imprimirlo en fomato json
        String jsonString = gson.toJson(vehiculos);
        return Response.status(200).entity(jsonString).build(); 
    }
    
    
    @PUT
    @Path("/actualizar")
    public Response actualizarUsuario(@QueryParam("id")int id, TipoVehiculo vehiculoRecibido){
        TipoVehiculo vehiculoActualizar = null;
        for(TipoVehiculo vehiculoR : vehiculos){
            if(vehiculoR.getIdTipoVehiculo() == (id)){
                vehiculoActualizar = vehiculoR;
                break;
            }
        }
        if(vehiculoActualizar != null){
            vehiculos.remove(vehiculoActualizar);
            vehiculos.add(vehiculoRecibido);
            Gson gson = new Gson();
            String gsonString = gson.toJson(vehiculos);
            return Response.status(200).entity(gsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Vehiculo no encontrado\"}").build();
        }
    }
    
    
    @DELETE
    @Path("/eliminar")
    public Response eliminarVehiculo(@QueryParam("id") int id){
        //Aqui implementar la logica para eliminar un usuario de la lista
        Gson gson = new Gson();
        
        TipoVehiculo vehiculoEliminar = null;
        for(TipoVehiculo vehiculoR : vehiculos){
            if(vehiculoR.getIdTipoVehiculo() == (id)){
                vehiculoEliminar = vehiculoR;
                break;
            }
        }
        if(vehiculoEliminar != null){
            vehiculos.remove(vehiculoEliminar);
            String jsonString = gson.toJson(vehiculos);
            return Response.status(200).entity(jsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Vehiculo no encontrado\"}").build();
        }
    }
}
