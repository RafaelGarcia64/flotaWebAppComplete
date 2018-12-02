/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.VehiculoFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Vehiculo;

/**
 *
 * @author rafael
 */
@Named(value = "frmVehiculo")
@ViewScoped
public class FrmVehiculo extends AbstractFrmBean<Vehiculo> implements Serializable {

    @EJB
    private VehiculoFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(Vehiculo object) {
        if (object != null) {
            return object.getIdVehiculo();
        }
        return null;
    }

    @Override
    public Vehiculo datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Long search = new Long(rowKey);
                for (Vehiculo tu : this.List) {
                    if (tu.getIdVehiculo().compareTo(search) == 0) {
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
    protected AbstractFacade<Vehiculo> getFacade() {
        return facade;
    }

    @Override
    public LazyDataModel<Vehiculo> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo getRegistro() {
        if (registro == null) {
            registro = new Vehiculo();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

}
