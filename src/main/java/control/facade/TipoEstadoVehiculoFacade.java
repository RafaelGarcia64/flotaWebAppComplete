/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}
