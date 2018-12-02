/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.ReservaFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Reserva;

/**
 *
 * @author rafael
 */
@Named(value = "frmReserva")
@ViewScoped
public class FrmReserva extends AbstractFrmBean<Reserva> implements Serializable {

    @EJB
    private ReservaFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(Reserva object) {
        if (object != null) {
            return object.getIdReserva();
        }
        return null;
    }

    @Override
    public Reserva datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Long search = new Long(rowKey);
                for (Reserva tu : this.List) {
                    if (tu.getIdReserva().compareTo(search) == 0) {
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
    protected AbstractFacade<Reserva> getFacade() {
        return facade;
    }

    @Override
    public Reserva getRegistro() {
        if (registro == null) {
            registro = new Reserva();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<Reserva> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
