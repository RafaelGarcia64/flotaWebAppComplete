/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.EstadoVehiculoFacade;
import control.facade.TipoEstadoVehiculoFacade;
import control.facade.VehiculoFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.EstadoVehiculo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoVehiculo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Vehiculo;

/**
 *
 * @author rafael
 */
@Named(value = "frmEstadoVehiculo")
@ViewScoped
public class FrmEstadoVehiculo extends AbstractFrmBean<EstadoVehiculo> implements Serializable {

    @EJB
    private VehiculoFacade vehiculoFacade;

    @EJB
    private TipoEstadoVehiculoFacade tipoEstadoVehiculoFacade;

    @EJB
    private EstadoVehiculoFacade estadoVehiculoFacade;

    private List<TipoEstadoVehiculo> listTipoEstadoV;
    private List<Vehiculo> listVehiculo;

    @PostConstruct
    @Override
    public void inicializar() {
        super.inicializar();
//        listTipoEstadoV = tipoEstadoVehiculoFacade.findAll();
//        listVehiculo = vehiculoFacade.findAll();
    }

    @Override
    public Object clavePorDatos(EstadoVehiculo object) {
        if (object != null) {
            return object.getIdEstadoVehiculo();
        }
        return null;
    }

    @Override
    public EstadoVehiculo datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Long search = new Long(rowKey);
                for (EstadoVehiculo tu : this.List) {
                    if (tu.getIdEstadoVehiculo().compareTo(search) == 0) {
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
    protected AbstractFacade<EstadoVehiculo> getFacade() {
        return estadoVehiculoFacade;
    }

    @Override
    public EstadoVehiculo getRegistro() {
        if (registro == null) {
            registro = new EstadoVehiculo();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<EstadoVehiculo> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TipoEstadoVehiculo> getListTipoEstadoV() {
        return listTipoEstadoV;
    }

    public List<Vehiculo> getListVehiculo() {
        return listVehiculo;
    }

}
