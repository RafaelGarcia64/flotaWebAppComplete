/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.TipoEstadoReservaFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;

/**
 *
 * @author rafael
 */
@Named(value = "frmTipoEstadoReserva")
@ViewScoped
public class frmTipoEstadoReserva extends AbstractFrmBean<TipoEstadoReserva> implements Serializable {

    @EJB
    private TipoEstadoReservaFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(TipoEstadoReserva object) {
        if (object != null) {
            return object.getIdTipoEstadoReserva();
        }
        return null;
    }

    @Override
    public TipoEstadoReserva datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (TipoEstadoReserva tu : this.List) {
                    if (tu.getIdTipoEstadoReserva().compareTo(search) == 0) {
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
    protected AbstractFacade<TipoEstadoReserva> getFacade() {
        return facade;
    }

    @Override
    public TipoEstadoReserva getRegistro() {
        if (this.registro == null) {
            registro = new TipoEstadoReserva();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<TipoEstadoReserva> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
