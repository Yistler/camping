/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.servicios;

import com.camping.losalerces.entidades.Representante;
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
@Path("/representantes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepresentanteService {
    //private List<Representante> representantes;
    public static final List<Representante> representantes = new ArrayList<>();
    static{
        representantes.add(new Representante("1-9", "John", "Trace", "+56989898989"));
        representantes.add(new Representante("2-7","Linda", "Stewart", "+56989898989"));
        representantes.add(new Representante("3-5", "Phil", "Col", "+56989898989"));
        representantes.add(new Representante("4-3", "Stan", "Sto", "+56989898989"));
    }
    @GET
    public Response consultarRepresentante() {
        Gson json = new Gson();
        String jsonString = json.toJson(representantes);
        return Response.status(200).entity(jsonString).build();
    }
    
    @POST
    @Path("/agregar")
    public Response agregarRepresentante(Representante representante){
        Gson json = new Gson();
        String jsonString = json.toJson(representante);
        Representante representanteRecibido = json.fromJson(jsonString, Representante.class);
        
        String representanteRecibidoNombres = representanteRecibido.getNombres();
        boolean existeRepresentante = false;
        for(Representante representanteExiste : representantes){
            if(representanteExiste.getNombres().equals(representanteRecibidoNombres)){
                existeRepresentante = true;
                break;
            }
        }
        if(existeRepresentante){
            return Response.status(Response.Status.CONFLICT).entity("{\"statusCode\": 409,\"body\": \"El representante ya existe\"}").build();
        }else{
            representantes.add( representanteRecibido);
            String representanteJson = json.toJson(representantes);
            return Response.status(200).entity(representanteJson).build();
        }
    }
    
    @PUT
    @Path("/actualizar")
    public Response actualizarRepresentante(@QueryParam("rut")String rut, Representante representanteRecibido){
        Representante representanteActualizar = null;
        for(Representante representanteR : representantes){
            if(representanteR.getRut().equalsIgnoreCase(rut)){
                representanteActualizar = representanteR;
                break;
            }
        }
        if(representanteActualizar != null){
            representantes.remove(representanteActualizar);
            representantes.add(representanteRecibido);
            Gson gson = new Gson();
            String gsonString = gson.toJson(representantes);
            return Response.status(200).entity(gsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Representante no encontrado\"}").build();
        }
    }
    
    
    @DELETE
    @Path("/eliminar")
    public Response eliminarRepresentante(@QueryParam("rut") String rut){
        //Aqui implementar la logica para eliminar un usuario de la lista
        Gson gson = new Gson();
        
        Representante representanteEliminar = null;
        for(Representante representanteR : representantes){
            if(representanteR.getRut().equalsIgnoreCase(rut)){
                representanteEliminar = representanteR;
                break;
            }
        }
        if(representanteEliminar != null){
            representantes.remove(representanteEliminar);
            String jsonString = gson.toJson(representantes);
            return Response.status(200).entity(jsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Representante no encontrado\"}").build();
        }
    }
}
