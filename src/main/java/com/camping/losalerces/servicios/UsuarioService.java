/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camping.losalerces.servicios;

import com.camping.losalerces.entidades.Usuarios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioService {   
    //lista para usar de BD donde almacena instancias de Usuarios
    private static final List<Usuarios> usuario = new ArrayList<>();
    static{
        usuario.add(new Usuarios("John Trace", "1234", "John", "Trace"));
        usuario.add(new Usuarios("Linda Stewart", "1234", "Linda", "Stewart"));
        usuario.add(new Usuarios("Phil Col", "1234", "Phil", "Col"));
        usuario.add(new Usuarios("Stan Sto", "1234", "Stan", "Sto"));
    }
    
    @GET
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public Response consultarUsuarios() throws JsonProcessingException{
        Gson gson = new Gson();
        String jsonString = gson.toJson(usuario);
        return Response.ok(jsonString).build();
    }
    
    @POST
    @Path("/agregar")
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarUsuario(Usuarios usuarioAgregado){
        //Aqui implementar la logica para agregar un usuario a la lista existente
        final Gson gson = new Gson();
        final String usuarioJson = gson.toJson(usuarioAgregado);
        final Usuarios usuarioRecibido = gson.fromJson(usuarioJson, Usuarios.class);
        
        String usuarioRecibidoNombre = usuarioRecibido.getNombres();
        boolean existeUsuario = false;
        for(Usuarios usuarioExiste : usuario){
            if(usuarioExiste.getNombres().equals(usuarioRecibidoNombre)){
                existeUsuario = true;
                break;
            }
        }
        if(existeUsuario){
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"statusCode\": 409, \"body\": \"El usuario ya existe\"}").build();
        }else{
            usuario.add(usuarioRecibido);
            String jsonString = gson.toJson(usuario);
            return Response.status(200).entity(jsonString).type(MediaType.APPLICATION_JSON).build();
        }
    }
    
    
    @PUT
    @Path("/actualizar")
    public Response actualizarUsuario(@QueryParam("nombres")String nombres, Usuarios usuarioRecibido){
        Usuarios usuarioActualizar = null;
        for(Usuarios usuarioR : usuario){
            if(usuarioR.getNombres().equalsIgnoreCase(nombres)){
                usuarioActualizar = usuarioR;
                break;
            }
        }
        if(usuarioActualizar != null){
            usuario.remove(usuarioActualizar);
            usuario.add(usuarioRecibido);
            Gson gson = new Gson();
            String gsonString = gson.toJson(usuario);
            return Response.status(200).entity(gsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Usuario no encontrado\"}").build();
        }
    }
    
    
    @DELETE
    @Path("/eliminar")
    public Response eliminarUsuario(@QueryParam("nombres") String nombres){
        //Aqui implementar la logica para eliminar un usuario de la lista
        Gson gson = new Gson();
        
        Usuarios usuarioEliminar = null;
        for(Usuarios usuarioR : usuario){
            if(usuarioR.getNombres().equalsIgnoreCase(nombres)){
                usuarioEliminar = usuarioR;
                break;
            }
        }
        if(usuarioEliminar != null){
            usuario.remove(usuarioEliminar);
            String jsonString = gson.toJson(usuario);
            return Response.status(200).entity(jsonString).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("{\"statusCode\": 404, \"message\": \"Usuario no encontrado\"}").build();
        }
    }
    
   
}
