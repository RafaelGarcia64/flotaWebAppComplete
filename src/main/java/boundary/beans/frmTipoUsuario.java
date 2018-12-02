/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.TipoUsuarioFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoUsuario;

/**
 *
 * @author rafael
 */
@Named(value = "frmTipoUsuario")
@ViewScoped
public class frmTipoUsuario extends AbstractFrmBean<TipoUsuario> implements Serializable {

    @EJB
    private TipoUsuarioFacade facade;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clavePorDatos(TipoUsuario object) {
        if (object != null) {
            return object.getIdTipoUsuario();
        }
        return null;
    }

    @Override
    public TipoUsuario datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (TipoUsuario tu : this.List) {
                    if (tu.getIdTipoUsuario().compareTo(search) == 0) {
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
    protected AbstractFacade<TipoUsuario> getFacade() {
        return facade;
    }

    @Override
    public LazyDataModel<TipoUsuario> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoUsuario getRegistro() {
        if (this.registro == null) {
            registro = new TipoUsuario();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

}
