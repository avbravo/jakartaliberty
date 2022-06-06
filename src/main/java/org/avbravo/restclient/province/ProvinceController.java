/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.avbravo.restclient.province;

//import com.avbravo.jmoordbutils.JsfUtil;
import org.avbravo.restclient.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.primefaces.PrimeFaces;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class ProvinceController implements Serializable {

    // <editor-fold defaultstate="collapsed" desc=" fields">
    String message = "";
    Province province = new Province();
    Province provinceSelected = new Province();
    List<Province> provinceList = new ArrayList<>();
    Integer id=0;
    Boolean found = false;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    ProvinceServices provinceServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" set/get">

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Province getProvinceSelected() {
        return provinceSelected;
    }

    public void setProvinceSelected(Province provinceSelected) {
        this.provinceSelected = provinceSelected;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

// </editor-fold>
    /**
     * Creates a new instance of SimpleController
     */
    public ProvinceController() {
    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        provinceList = provinceServices.findAll();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="clear()">

    public String clear() {
        message = "";
        province = new Province();
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareAdd()">

    public String prepareAdd() {
        message = "";
        province = new Province();
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String getHello()">
    public String getHello() {
        try {

            message = provinceServices.getHello();

        } catch (Exception e) {

            JsfUtil.errorDialog("getHello(", e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String first()">
    public String first() {
        try {

            province = provinceServices.first();

        } catch (Exception e) {

            JsfUtil.errorDialog("first()", e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String findAll()">
    public String findAll() {
        try {

            provinceList = provinceServices.findAll();

        } catch (Exception e) {

            JsfUtil.errorDialog("findAll()", e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="save()">
    public void add() {
        try {

            Response response = provinceServices.add(provinceSelected);

            if (response.getStatus() == 400) {

                JsfUtil.errorMessage("No se pudo guardar");

            } else {
                JsfUtil.successMessage("Guardado exitosamente");
                findAll();
                PrimeFaces.current().executeScript("PF('provinceDialog').hide()");
                PrimeFaces.current().ajax().update("form:growl", "form:provinceDataTable");

            }
        } catch (Exception e) {
            JsfUtil.errorDialog("add()", e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="update()">

    public void update() {
        try {

            Response response = provinceServices.update(provinceSelected);

            if (response.getStatus() == 400) {

                JsfUtil.errorMessage("No se pudo Editar");

            } else {
                JsfUtil.successMessage("Editado exitosamente");
                findAll();
                PrimeFaces.current().executeScript("PF('provinceDialog').hide()");
                PrimeFaces.current().ajax().update("form:growl", "form:provinceDataTable");

            }
        } catch (Exception e) {
            JsfUtil.errorDialog("update()", e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="delete()">

    public void delete() {
        try {
            Response response = provinceServices.delete(provinceSelected.getIdprovince());

            if (response.getStatus() == 400) {

                JsfUtil.errorMessage("No se pudo eliminar");

            } else {
                JsfUtil.successMessage("Eliminado exitosamente");
                findAll();
                PrimeFaces.current().executeScript("PF('provinceDialog').hide()");
                PrimeFaces.current().ajax().update("form:growl", "form:provinceDataTable");

            }
        } catch (Exception e) {
            JsfUtil.errorDialog("update()", e.getLocalizedMessage());
        }

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" search">

    public String search() {
        try {

            province = provinceServices.findById(id);
            if (province == null || province.getIdprovince()== null) {
                JsfUtil.warningMessage("No lo encontro...");
            } else {
                JsfUtil.successMessage("Name =" + province.getProvince());
                message = province.getProvince();
            }
        } catch (Exception e) {
            JsfUtil.errorDialog("findAll()", e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="openNew()">
    public void openNew() {
        found = false;
        this.provinceSelected = new Province();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void prepareQuery()">
    public String prepareQuery() {
        found = true;
        return "";
      }
// </editor-fold>
    

}
