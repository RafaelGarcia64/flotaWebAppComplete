/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.beans;

import control.facade.AbstractFacade;
import control.facade.ModeloFacade;
import control.facade.ModeloParteFacade;
import control.facade.ParteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Modelo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.ModeloParte;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Parte;

final class FrmModeloParte extends AbstractFrmBean<ModeloParte> implements Serializable {

    @EJB
    ModeloParteFacade modeloParteFacade;
    @EJB
    ModeloFacade modeloFacade;
    @EJB
    ParteFacade parteFacade;
    @EJB
    Modelo modeloEntity;
    
    protected int tabSeleccionado=0;
    List<Parte> listaParte;
    private ModeloParte modeloParte;
    Parte registre;

    FrmModeloParte(ModeloParteFacade modeloParteFacade, ModeloFacade modeloFacade, ParteFacade parteFacade, Modelo registro) {
        this.modeloParteFacade = modeloParteFacade;
        this.modeloFacade = modeloFacade;
        this.parteFacade = parteFacade;
        this.modeloEntity = registro;
        inicializar();
    }

    @Deprecated
    public List<ModeloParte> obtenerTodos() {
        List<ModeloParte> salida = new ArrayList();
        try {
            if (modeloParteFacade != null) {
                salida = modeloParteFacade.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

    @PostConstruct
    @Override
    public void inicializar() {

        super.inicializar();
        crearNuevo();
        try {
            this.listaParte = parteFacade.findAll();
        } catch (Exception ex) {
            this.listaParte = Collections.EMPTY_LIST;
        }
    }

    @Override
    public Object clavePorDatos(ModeloParte object) {
        if (object != null) {
            return object.getIdModeloParte();
        }
        return null;
    }

    @Override
    public ModeloParte datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getModelo().getWrappedData().stream().filter(r -> r.getIdModeloParte().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade<ModeloParte> getFacade() {
        return modeloParteFacade;
    }

    @Override
    public void crearNuevo() {
        this.registro = new ModeloParte();
    }

    @Override
    public LazyDataModel<ModeloParte> getModelo() {
        return super.getModelo();
    }

    /**
     * Propiedad sintetica para cambiar de Parte
     *
     * @return
     */
    public Integer getIdParteSeleccionada() {
        if (this.registro != null && this.registro.getIdParte() != null) {
            return this.registro.getIdParte().getIdParte();
        }
        return null;
    }

    /**
     * Propiedad sintetica para cambiar de Parte
     *
     * @param idParte
     */
    public void setIdParteSeleccionada(Integer idParte) {
        if (this.registro != null && this.listaParte != null) {
            try {
                this.registro.setIdParte(this.listaParte.stream().filter(m -> m.getIdParte().compareTo(idParte) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {

            }
        }
    }
    
     public List<String> completeText(String query) {
        List<String> results = new ArrayList<>();
        for (Parte part : listaParte) {
            results.add(query + part );
        }
         
        return results;
    }
   
    public List<Parte> getListaParte() {
        return listaParte;
    }

    public void setListaParte(List<Parte> listaParte) {
        this.listaParte = listaParte;
    }

    public ModeloParteFacade getModeloParteFacade() {
        return modeloParteFacade;
    }

    public void setModeloParteFacade(ModeloParteFacade modeloParteFacade) {
        this.modeloParteFacade = modeloParteFacade;
    }

    public ModeloFacade getModeloFacade() {
        return modeloFacade;
    }

    public void setModeloFacade(ModeloFacade modeloFacade) {
        this.modeloFacade = modeloFacade;
    }

    public ParteFacade getParteFacade() {
        return parteFacade;
    }

    public void setParteFacade(ParteFacade parteFacade) {
        this.parteFacade = parteFacade;
    }

    public Modelo getModeloEntity() {
        return modeloEntity;
    }

    public void setModeloEntity(Modelo modeloEntity) {
        this.modeloEntity = modeloEntity;
    }

    public int getTabSeleccionado() {
        return tabSeleccionado;
    }

    public void setTabSeleccionado(int tabSeleccionado) {
        this.tabSeleccionado = tabSeleccionado;
    }

    public Parte getRegistre() {
        return registre;
    }

    public void setRegistre(Parte registre) {
        this.registre = registre;
    }
    
    public ModeloParte getModeloParte() {
        return modeloParte;
    }

    public void setModeloParte(ModeloParte modeloParte) {
        this.modeloParte = modeloParte;
    }

    @Override
    public ModeloParte getRegistro() {
        return registro;
    }

    @Override
    public void setRegistro(ModeloParte registro) {
        this.registro = registro;
    }

}
