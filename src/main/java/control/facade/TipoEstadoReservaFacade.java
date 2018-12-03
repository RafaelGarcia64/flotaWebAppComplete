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
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author rafael
 */
@Stateless
public class TipoEstadoReservaFacade extends AbstractFacade<TipoEstadoReserva> {

    @PersistenceContext(unitName = "flotilla-unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEstadoReservaFacade() {
        super(TipoEstadoReserva.class);
    }

    public List<TipoEstadoReserva> findLike(String busqueda) {
        Query resultado = em.createQuery("SELECT t FROM TipoEstadoReserva t WHERE t.nombre LIKE '%" + busqueda + "%'");
        return resultado.getResultList();
    }

    public TipoEstadoReserva crear(TipoEstadoReserva entity) {
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

    public TipoEstadoReserva editar(TipoEstadoReserva entity) {
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

    public TipoEstadoReserva remover(TipoEstadoReserva entity) {
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
