/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.TipoEstadoVehiculoFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoVehiculo;

/**
 *
 * @author rafael
 */
@Named(value = "frmTipoEstadoVehiculo")
@ViewScoped
public class FrmTipoEstadoVehiculo extends AbstractFrmBean<TipoEstadoVehiculo> implements Serializable {

    @EJB
    private TipoEstadoVehiculoFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(TipoEstadoVehiculo object) {
        if (object != null) {
            return object.getIdTipoEstadoVehiculo();
        }
        return null;
    }

    @Override
    public TipoEstadoVehiculo datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (TipoEstadoVehiculo tu : this.List) {
                    if (tu.getIdTipoEstadoVehiculo().compareTo(search) == 0) {
                        return tu;
                    }
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    public LazyDataModel<TipoEstadoVehiculo> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoEstadoVehiculo getRegistro() {
        if (registro == null) {
            registro = new TipoEstadoVehiculo();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected AbstractFacade<TipoEstadoVehiculo> getFacade() {
        return facade;
    }

}
