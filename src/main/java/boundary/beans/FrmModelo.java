/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.ModeloFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Modelo;

/**
 *
 * @author rafael
 */
@Named(value = "frmModelo")
@ViewScoped
public class FrmModelo extends AbstractFrmBean<Modelo> implements Serializable {

    @EJB
    private ModeloFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(Modelo object) {
        if (object != null) {
            return object.getIdModelo();
        }
        return null;
    }

    @Override
    public Modelo datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (Modelo tu : this.List) {
                    if (tu.getIdModelo().compareTo(search) == 0) {
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
    protected AbstractFacade<Modelo> getFacade() {
        return facade;
    }

    @Override
    public Modelo getRegistro() {
        if (registro == null) {
            registro = new Modelo();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<Modelo> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

}
