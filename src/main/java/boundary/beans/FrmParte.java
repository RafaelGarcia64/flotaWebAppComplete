/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.ParteFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Parte;

/**
 *
 * @author rafael
 */
@Named(value = "frmParte")
@ViewScoped
public class FrmParte extends AbstractFrmBean<Parte> implements Serializable {

    @EJB
    private ParteFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(Parte object) {
        if (object != null) {
            return object.getIdParte();
        }
        return null;
    }

    @Override
    public Parte datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (Parte tu : this.List) {
                    if (tu.getIdParte().compareTo(search) == 0) {
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
    protected AbstractFacade<Parte> getFacade() {
        return facade;
    }

    @Override
    public Parte getRegistro() {
        if (registro == null) {
            registro = new Parte();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<Parte> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
