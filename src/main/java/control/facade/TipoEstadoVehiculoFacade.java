/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoVehiculo;

/**
 *
 * @author rafael
 */
@Stateless
public class TipoEstadoVehiculoFacade extends AbstractFacade<TipoEstadoVehiculo> {

    @PersistenceContext(unitName = "flotilla-unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEstadoVehiculoFacade() {
        super(TipoEstadoVehiculo.class);
    }

    public List<TipoEstadoVehiculo> findLike(String busqueda) {
        Query resultado = em.createQuery("SELECT t FROM TipoEstadoVehiculo t WHERE t.nombre LIKE '%" + busqueda + "%'");
        return resultado.getResultList();
    }

    public TipoEstadoVehiculo crear(TipoEstadoVehiculo entity) {
        try {
            if (em != null && entity != null) {
                em.persist(entity);
                return entity;
            } else {
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public TipoEstadoVehiculo editar(TipoEstadoVehiculo entity) {
        try {
            if (em != null && entity != null) {
                em.merge(entity);
                return entity;
            } else {
                System.out.println("algo es nulo");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

        return null;
    }

    public TipoEstadoVehiculo remover(TipoEstadoVehiculo entity) {
        try {
            if (em != null && entity != null) {
                em.remove(getEntityManager().merge(entity));
                return entity;
            } else {
                System.out.println("algo es nulo");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

}
