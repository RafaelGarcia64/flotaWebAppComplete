/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.SubTipoParteFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.SubTipoParte;

/**
 *
 * @author rafael
 */
@Named(value = "frmSubTipoParte")
@ViewScoped
public class FrmSubTipoParte extends AbstractFrmBean<SubTipoParte> implements Serializable {

    @EJB
    private SubTipoParteFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(SubTipoParte object) {
        if (object != null) {
            return object.getIdSubTipoParte();
        }
        return null;
    }

    @Override
    public SubTipoParte datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (SubTipoParte tu : this.List) {
                    if (tu.getIdSubTipoParte().compareTo(search) == 0) {
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
    protected AbstractFacade<SubTipoParte> getFacade() {
        return facade;
    }

    @Override
    public SubTipoParte getRegistro() {
        if (registro == null) {
            registro = new SubTipoParte();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<SubTipoParte> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
