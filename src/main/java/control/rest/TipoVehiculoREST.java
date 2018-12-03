/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.rest;

import control.facade.TipoVehiculoFacade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo;

/**
 *
 * @author rafael
 */
@Path("tipoVehiculo")
@RequestScoped
public class TipoVehiculoREST {

    @EJB
    private TipoVehiculoFacade facade;

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public Response Count() {
        if (facade != null) {
            try {
                int totalRegistros = facade.count();
                if (totalRegistros != 0) {
                    return Response.status(Response.Status.OK)
                            .entity(totalRegistros).build();
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }
        return Response.status(Response.Status.NOT_FOUND)
                .header("No se encontraron Registros", facade)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscarID(@PathParam("id") Integer identificador) {
        TipoVehiculo buscado = facade.find(identificador);

        try {
            if (identificador >= 0 && buscado != null) {
                return Response.status(Response.Status.OK).entity(buscado).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return Response.status(Response.Status.BAD_REQUEST).header("no se encontro registro:", identificador).build();
    }

    @GET
    @Path("todo")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoVehiculo> buscarTodo() {//Busqueda realizada en toda la bd, de cada registro
        List<TipoVehiculo> lista = new ArrayList<>();

        if (facade != null) {
            try {
                if (facade.findAll() != null) {
                    return lista = facade.findAll();
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }
        return lista = Collections.EMPTY_LIST;
    }

    @GET
    @Path("Range")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoVehiculo> buscarPorRango( //busqueda realizada entre un rango, pasando por defecto desde cero hasta 10
            @QueryParam("inicio") @DefaultValue("0") int primero,
            @QueryParam("cantidad") @DefaultValue("10") int pagezise) {
        List<TipoVehiculo> lista;
        if (facade != null) {//verificamos si el facade no es nulo
            try {

                return lista = facade.findRange(primero, pagezise); //retornamos la lista con los registros en ese dato

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }

        return lista = Collections.EMPTY_LIST; // si no se encuentran los registros, retornamos una lista vacia
    }

    @GET
    @Path("like")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoVehiculo> BuscarLike(@QueryParam("busqueda") String busqueda) { //metodo para buscar un registro atravez de una cadena de texto como parametro
        List<TipoVehiculo> ListaLike = new ArrayList<>();
        if (facade != null) {//verificamos si el facade de la entidad no es nulo
            try {
                if (busqueda != null && !(busqueda.equals(""))) {//validamos que la busqueda no sea nula o vacia
                    ListaLike = facade.findLike(busqueda); //retornamos el registro si la busqueda es exitosa
                } else {
                    ListaLike = Collections.EMPTY_LIST;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return ListaLike;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public TipoVehiculo Crear(TipoVehiculo registro) {
        TipoVehiculo nuevo = facade.crear(registro);
        return nuevo;
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public TipoVehiculo Modificar(TipoVehiculo registro) {
        if (registro != null) {
            try {
                if (facade != null) {
                    TipoVehiculo nuevo = facade.editar(registro);
                    if (nuevo != null) {
                        return nuevo;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new TipoVehiculo();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TipoVehiculo eliminar(@PathParam("id") int idTipo) {
        if (idTipo > 0) {
            try {
                if (facade != null) {
                    TipoVehiculo die = facade.remover(facade.find(idTipo));
                    if (die != null) {
                        return die;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new TipoVehiculo();
    }
}
