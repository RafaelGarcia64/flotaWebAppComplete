/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author rafael
 * @param <T>
 */
public abstract class AbstractFrmBean<T> {
protected T registro;

    public abstract Object clavePorDatos(T object);

    public abstract T datosPorClave(String rowKey);

    protected abstract AbstractFacade<T> getFacade();
    List<T> List = new ArrayList<>();
    protected LazyDataModel<T> modelo;

    public abstract void crearNuevo();


    public void inicializar() {
        Modelo();
        if (getFacade().findAll() != null) {
            List = getFacade().findAll();
        } else {
            List = Collections.EMPTY_LIST;
        }
        crearNuevo();
    }

    public void resetRegistro() {
        setRegistro(null);
        registro = null;
    }

    public void btnEliminarHandler(ActionEvent ae) {
        if (getFacade() != null && registro != null) {
            try {
                getFacade().remove(registro);
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void btnCancelarHandler(ActionEvent ae) {
        this.resetRegistro();
    }

    public LazyDataModel<T> Modelo() {
        try {
            modelo = new LazyDataModel<T>() {
                @Override
                public Object getRowKey(T object) {
                    return clavePorDatos(object);
                }

                @Override
                public T getRowData(String rowKey) {
                    return datosPorClave(rowKey);
                }

                @Override
                public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<T> salida = new ArrayList<>();
                    try {
                        if (getFacade() != null) {
                            this.setRowCount(getFacade().count());
                            salida = getFacade().findRange(first, pageSize);
                        }
                       
                      
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

    public LazyDataModel<T> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<T> modelo) {
        this.modelo = modelo;
    }
}
