/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.TipoVehiculoFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo;

/**
 *
 * @author rafael
 */
@Named(value = "frmTipoVehiculo")
@ViewScoped
public class FrmTipoVehiculo extends AbstractFrmBean<TipoVehiculo> implements Serializable {

    @Inject
    private TipoVehiculoFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar();
        this.registro = new TipoVehiculo();
    }

    @Override
    public void onRowDeselect(UnselectEvent event) {
        super.onRowDeselect(event); //To change body of generated methods, choose Tools | Templates.
        this.registro = new TipoVehiculo();
    }

    @Override
    public Object clavePorDatos(TipoVehiculo object) {
        if (object != null) {
            return object.getIdTipoVehiculo();
        }
        return null;
    }

    @Override
    public TipoVehiculo datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (TipoVehiculo tu : this.List) {
                    if (tu.getIdTipoVehiculo().compareTo(search) == 0) {
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
    protected AbstractFacade<TipoVehiculo> getFacade() {
        return facade;
    }

    @Override
    public LazyDataModel<TipoVehiculo> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoVehiculo getRegistro() {
        if (this.registro == null) {
            registro = new TipoVehiculo();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

}
