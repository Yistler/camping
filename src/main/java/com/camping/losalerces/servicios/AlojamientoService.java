/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.servicios;

import com.camping.losalerces.entidades.Alojamiento;
import com.camping.losalerces.entidades.Representante;
import com.camping.losalerces.entidades.TipoAlojamiento;
import com.camping.losalerces.entidades.TipoVehiculo;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@Path("/alojamientos")
@Produces(MediaType.APPLICATION_JSON)
public class AlojamientoService {
    private static final List<Alojamiento> alojamientos = new ArrayList<>();
    
    @GET
    public Response consultarAlojamientos(){
        Gson json = new Gson();
        String jsonString = json.toJson(alojamientos);
        return Response.ok(jsonString).build();  
    }
    
    @POST
    @Path("/agregar")
    public Response agregarAlojamiento(Alojamiento alojamiento){
        Gson gson = new Gson();//creo instancia de la clase gson
        //serializo a json el alojamiento recibido por la peticion post y lo almaceno en una variable
        String jsonString = gson.toJson(alojamiento);
        
        //deserializo el objeto json enviado para que ahora sea un entidad de java (Alojamiento)
        Alojamiento alojamientoRecibido = gson.fromJson(jsonString, Alojamiento.class);

        boolean rutExiste = false;
        boolean vehiculoExiste = false;
        boolean alojamientoExite = false;
        
        //verificar si el id de vehiculo proporcionado coincide con el id de un vehiculo existente en la lista de la clase TipoVehiculoService
        for(TipoVehiculo vehiculo : TipoVehiculoService.vehiculos){
            if(vehiculo.getIdTipoVehiculo() == alojamientoRecibido.getIdTipoVehiculo()){
                vehiculoExiste = true;
                break;//termina el ciclo si el vehiculo existe
            }
        }
        if(!vehiculoExiste){
            return Response.status(Response.Status.CONFLICT).entity("{\"statusCode\": 200, \"Body\": \"El Id de vehiculo no coincide o no existe\"}").build();
        }
        
        //verificar si el id de alojamiento proporcionado coincide con el id de un alojamiento existente en la lista de la clase TipoAlojamientoService
        for(TipoAlojamiento alojamientoA : TipoAlojamientoService.alojamientos){
            if(alojamientoA.getIdTipoAlojamiento() == alojamientoRecibido.getIdTipoAlojamiento()){
                alojamientoExite = true; 
                break;//termina el ciclo si el alojamiento existe
            }
        }if(!alojamientoExite){
            return Response.status(Response.Status.CONFLICT).entity("{\"statusCode\": 200, \"Body\": \"El Id de alojamiento no coincide o no existe\"}").build();
        }
       
        //verifica si el rut proporcionado es igual al rut existente de la lista de la clase representanteService
        for(Representante representanteA : RepresentanteService.representantes){
            if(alojamientoRecibido.getRut().equalsIgnoreCase(representanteA.getRut())){
                rutExiste = true;
                break;//temina el ciclo si el alojamiento existe
            }
        }
        if(!rutExiste){
            return Response.status(Response.Status.CONFLICT).entity("{\"statusCode\": 200, \"Body\": \"El rut no coincide o no existe\"}").build();
        }
        
        
        if(vehiculoExiste && alojamientoExite && rutExiste){
           alojamientos.add(alojamientoRecibido);
           String gsonString = gson.toJson(alojamientos);
           return Response.status(200).entity(gsonString).build();   
        }
        
        return null;
    }
    
    @PUT
    @Path("/actualizar")
    public Response actualizarAlojamiento(@QueryParam("rut")String rut, Alojamiento alojamientoRecibido){
        Alojamiento alojamientoActualizar = null;
        for(Alojamiento AlojamientoR : alojamientos){
            if(AlojamientoR.getRut().equalsIgnoreCase(rut)){
                alojamientoActualizar = AlojamientoR;
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
    public Response eliminarAlojamiento(@QueryParam("rut") String rut){
        //Aqui implementar la logica para eliminar un usuario de la lista
        Gson gson = new Gson();
        
        Alojamiento alojamientoEliminar = null;
        for(Alojamiento alojamientoR : alojamientos){
            if(alojamientoR.getRut().equalsIgnoreCase(rut)){
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
