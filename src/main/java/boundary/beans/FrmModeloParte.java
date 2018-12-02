/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.ModeloParteFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.ModeloParte;

/**
 *
 * @author rafael
 */
@Named(value = "frmModeloParte")
@ViewScoped
public class FrmModeloParte extends AbstractFrmBean<ModeloParte> implements Serializable {

    @EJB
    private ModeloParteFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(ModeloParte object) {
        if (object != null) {
            return object.getIdModeloParte();
        }
        return null;
    }

    @Override
    public ModeloParte datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Long search = new Long(rowKey);
                for (ModeloParte tu : this.List) {
                    if (tu.getIdModeloParte().compareTo(search) == 0) {
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
    protected AbstractFacade<ModeloParte> getFacade() {
        return facade;
    }

    @Override
    public ModeloParte getRegistro() {
        if (registro == null) {
            registro = new ModeloParte();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<ModeloParte> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
