package org.ngarcia.webapp.jaxws.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ngarcia.webapp.jaxws.models.Curso;
import org.ngarcia.webapp.jaxws.services.CursoService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
//@Produces(MediaType.APPLICATION_XML) //jakarta.ws.rs
@Produces(MediaType.APPLICATION_JSON) //jakarta.ws.rs
public class CursoRestController {

    @Inject
    private CursoService service;

    //@GET
    //public List<Curso> listar() {
    //    return service.listar();
    //}
    @GET
    public Response listar() {
        return Response.ok(service.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        Optional<Curso> opt = service.porId(id);
        if(opt.isPresent()) {
            return Response.ok(opt.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
