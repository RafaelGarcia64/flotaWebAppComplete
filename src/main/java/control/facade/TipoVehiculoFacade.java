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
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo;

/**
 *
 * @author rafael
 */
@Stateless
public class TipoVehiculoFacade extends AbstractFacade<TipoVehiculo> {

    @PersistenceContext(unitName = "flotilla-unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoVehiculoFacade() {
        super(TipoVehiculo.class);
    }

    public List<TipoVehiculo> findLike(String busqueda) {
        Query resultado = em.createQuery("SELECT t FROM TipoVehiculo t WHERE t.nombre LIKE '%" + busqueda + "%'");
        return resultado.getResultList();
    }

    public TipoVehiculo crear(TipoVehiculo entity) {
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

    public TipoVehiculo editar(TipoVehiculo entity) {
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

    public TipoVehiculo remover(TipoVehiculo entity) {
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
