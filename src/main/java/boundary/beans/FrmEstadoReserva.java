/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.EstadoReservaFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.EstadoReserva;

/**
 *
 * @author rafael
 */
@Named(value = "frmEstadoReserva")
@ViewScoped
public class FrmEstadoReserva extends AbstractFrmBean<EstadoReserva> implements Serializable {

    @EJB
    private EstadoReservaFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(EstadoReserva object) {
        if (object != null) {
            return object.getIdEstadoReserva();
        }
        return null;
    }

    @Override
    public EstadoReserva datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Long search = new Long(rowKey);
                for (EstadoReserva tu : this.List) {
                    if (tu.getIdEstadoReserva().compareTo(search) == 0) {
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
    protected AbstractFacade<EstadoReserva> getFacade() {
        return facade;
    }

    @Override
    public EstadoReserva getRegistro() {
        if (registro == null) {
            registro = new EstadoReserva();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<EstadoReserva> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
