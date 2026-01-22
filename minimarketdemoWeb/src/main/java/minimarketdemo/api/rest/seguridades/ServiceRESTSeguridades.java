package minimarketdemo.api.rest.seguridades;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.seguridades.dtos.LoginDTO;
import minimarketdemo.model.seguridades.managers.ManagerSeguridades;

@RequestScoped
@Path("seguridades") 
@Produces("application/json")
@Consumes("application/json")
public class ServiceRESTSeguridades {

    @EJB
    private ManagerSeguridades mSeguridades;

    @GET
    @Path("usuarios")
    public List<SegUsuario> findAllUsuarios() {
        return mSeguridades.findAllUsuarios();
    }

    @GET
    @Path("usuarios/{id}")
    public SegUsuario findById(@PathParam("id") int id) throws Exception {
        return mSeguridades.findByIdSegUsuario(id);
    }

    @POST
    @Path("usuarios")
    public Response crearUsuario(SegUsuario usuario) {
        try {
            usuario.setActivo(true);
            usuario.setCodigo("REST"); 
            mSeguridades.insertarUsuario(usuario);
            return Response.ok(usuario).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("usuarios/{id}")
    public Response actualizarUsuario(@PathParam("id") int id, SegUsuario usuario) {
        try {
            usuario.setIdSegUsuario(id);
            
            LoginDTO dummyLogin = new LoginDTO();
            dummyLogin.setIdSegUsuario(1);
            dummyLogin.setDireccionIP("REST-CLIENT");
            
            mSeguridades.actualizarUsuario(dummyLogin, usuario);
            
            return Response.ok("{\"mensaje\":\"Usuario actualizado exitosamente\"}").build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return Response.status(500).entity("{\"error\":\"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("usuarios/{id}")
    public Response eliminarUsuario(@PathParam("id") int id) {
        try {
            mSeguridades.eliminarUsuario(id);
            
            return Response.ok("{\"mensaje\":\"Usuario eliminado exitosamente\"}").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"error\":\"" + e.getMessage() + "\"}").build();
        }
    }
}