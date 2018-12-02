/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.RecorridoFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Recorrido;

/**
 *
 * @author rafael
 */
@Named(value = "frmRecorrido")
@ViewScoped
public class FrmRecorrido extends AbstractFrmBean<Recorrido> implements Serializable {

    @EJB
    private RecorridoFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(Recorrido object) {
        if (object != null) {
            return object.getIdRecorrido();
        }
        return null;
    }

    @Override
    public Recorrido datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Long search = new Long(rowKey);
                for (Recorrido tu : this.List) {
                    if (tu.getIdRecorrido().compareTo(search) == 0) {
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
    protected AbstractFacade<Recorrido> getFacade() {
        return facade;
    }

    @Override
    public LazyDataModel<Recorrido> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recorrido getRegistro() {
        if (registro == null) {
            registro = new Recorrido();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

}
