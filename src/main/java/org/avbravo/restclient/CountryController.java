/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.avbravo.restclient;

//import com.avbravo.jmoordbutils.JsfUtil;
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
public class CountryController implements Serializable {

    // <editor-fold defaultstate="collapsed" desc=" fields">
    String message = "";
    Country country = new Country();
    Country countrySelected = new Country();
    List<Country> countryList = new ArrayList<>();
    String id = new String();
    Boolean found = false;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    CountryServices countryServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" set/get">

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }
    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Country getCountrySelected() {
        return countrySelected;
    }

    public void setCountrySelected(Country countrySelected) {
        this.countrySelected = countrySelected;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

// </editor-fold>
    /**
     * Creates a new instance of SimpleController
     */
    public CountryController() {
    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        countryList = countryServices.findAll();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="clear()">

    public String clear() {
        message = "";
        country = new Country();
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareAdd()">

    public String prepareAdd() {
        message = "";
        country = new Country();
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String getHello()">
    public String getHello() {
        try {

            message = countryServices.getHello();

        } catch (Exception e) {

            JsfUtil.errorDialog("getHello(", e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String first()">
    public String first() {
        try {

            country = countryServices.first();

        } catch (Exception e) {

            JsfUtil.errorDialog("first()", e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String findAll()">
    public String findAll() {
        try {

            countryList = countryServices.findAll();

        } catch (Exception e) {

            JsfUtil.errorDialog("findAll()", e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="save()">
    public void add() {
        try {

            Response response = countryServices.add(countrySelected);

            if (response.getStatus() == 400) {

                JsfUtil.errorMessage("No se pudo guardar");

            } else {
                JsfUtil.successMessage("Guardado exitosamente");
                findAll();
                PrimeFaces.current().executeScript("PF('countryDialog').hide()");
                PrimeFaces.current().ajax().update("form:growl", "form:countryDataTable");

            }
        } catch (Exception e) {
            JsfUtil.errorDialog("add()", e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="update()">

    public void update() {
        try {

            Response response = countryServices.update(countrySelected);

            if (response.getStatus() == 400) {

                JsfUtil.errorMessage("No se pudo Editar");

            } else {
                JsfUtil.successMessage("Editado exitosamente");
                findAll();
                PrimeFaces.current().executeScript("PF('countryDialog').hide()");
                PrimeFaces.current().ajax().update("form:growl", "form:countryDataTable");

            }
        } catch (Exception e) {
            JsfUtil.errorDialog("update()", e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="delete()">

    public void delete() {
        try {
            Response response = countryServices.delete(countrySelected.getIdcountry());

            if (response.getStatus() == 400) {

                JsfUtil.errorMessage("No se pudo eliminar");

            } else {
                JsfUtil.successMessage("Eliminado exitosamente");
                findAll();
                PrimeFaces.current().executeScript("PF('countryDialog').hide()");
                PrimeFaces.current().ajax().update("form:growl", "form:countryDataTable");

            }
        } catch (Exception e) {
            JsfUtil.errorDialog("update()", e.getLocalizedMessage());
        }

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" search">

    public String search() {
        try {

            country = countryServices.findById(id);
            if (country == null || country.getIdcountry()== null) {
                JsfUtil.warningMessage("No lo encontro...");
            } else {
                JsfUtil.successMessage("Name =" + country.getCountry());
                message = country.getCountry();
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
        this.countrySelected = new Country();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void prepareQuery()">
    public String prepareQuery() {
        found = true;
        return "";
      }
// </editor-fold>
    

}
