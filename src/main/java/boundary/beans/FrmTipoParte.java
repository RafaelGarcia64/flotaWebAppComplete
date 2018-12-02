/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.TipoParteFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoParte;

/**
 *
 * @author rafael
 */
@Named(value = "frmTipoParte")
@ViewScoped
public class FrmTipoParte extends AbstractFrmBean<TipoParte> implements Serializable {

    @Inject
    private TipoParteFacade facade;

    @Override
    @PostConstruct
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(TipoParte object) {
        if (object != null) {
            return object.getIdTipoParte();
        }
        return null;
    }

    @Override
    public TipoParte datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (TipoParte tu : this.List) {
                    if (tu.getIdTipoParte().compareTo(search) == 0) {
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
    protected AbstractFacade<TipoParte> getFacade() {
        return facade;
    }

    @Override
    public LazyDataModel<TipoParte> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoParte getRegistro() {
        if (this.registro == null) {
            registro = new TipoParte();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

}
