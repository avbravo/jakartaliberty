/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.avbravo.restclient;

import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


/**
 *
 * @author avbravo
 */
public class JsfUtil {
    private static final Logger LOG = Logger.getLogger(JsfUtil.class.getName());
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // <editor-fold defaultstate="collapsed" desc="errorMessage"> 

    public static void errorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            errorMessage(msg);
        } else {
            errorMessage(defaultMsg);
        }
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="errorMessages"> 

    public static void errorMessages(List<String> messages) {
        for (String message : messages) {
            errorMessage(message);

        }
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="errorMessage(String msg)"> 

    public static void errorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        LOG.warning(msg);
    }    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="testMessage"> 
    public static void testMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        LOG.warning(msg);
    }    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="successMessage"> 
    public static void successMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,
                msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="warningMessage"> 

    public static void warningMessage(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, ""));
        LOG.warning(msg);
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="warningMessage(String msg, Exception e)"> 

    public static void warningMessage(String msg, Exception e) {
        String msgExtra=""; 
        if(e==null){
                
                }else{
                   msgExtra =e.getLocalizedMessage();
                }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg + " "+msgExtra, ""));
        LOG.warning(msg);
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="fatalMessage"> 

    public static void fatalMessage(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, ""));
        LOG.warning(msg);
    }    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="infoDialog"> 
    public static void infoDialog(String titulo, String texto) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo,
                texto);
        PrimeFaces.current().dialog().showMessageDynamic(message );
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="warningDialog(String titulo, String texto)"> 
    public static void warningDialog(String titulo, String texto) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo,
                texto);

        PrimeFaces.current().dialog().showMessageDynamic(message);

    }    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="warningDialogwarningDialog(String texto) "> 
    public static void warningDialog(String texto) {
      String titulo ="Advertencia";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo,
                texto);

        PrimeFaces.current().dialog().showMessageDynamic(message);

    }    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="warningSaveDialog(Exception exception,String...languague) ">
    public static void warningSaveDialog(Exception exception,String...languague){
        try {
            String translation="es";

            if (languague.length != 0) {
                translation = languague[0];
            }
            translation=translation.toLowerCase();
            String titulo ="Advertencia";
            String message="No se guardo el registro";
            switch(translation){
                case "es":
                    titulo="Advertencia";
                    message="No se guardo el registro";
                    break;
                case "en":
                    titulo="Warning";
                    message="No save";
                    break;
                    
            }
            if(exception != null){
                warningDialog(titulo, message, exception);
            }else{
                warningDialog(titulo, message);
            }
                    
            
        } catch (Exception e) {
            warningDialog(nameOfMethod(),e.getLocalizedMessage());
        }
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="warningUpdateDialog(Exception exception,String...languague) ">
    public static void warningUpdateDialog(Exception exception,String...languague){
        try {
            String translation="es";

            if (languague.length != 0) {
                translation = languague[0];
            }
            translation=translation.toLowerCase();
            String titulo ="Advertencia";
            String message="No se actualizo el registro";
            switch(translation){
                case "es":
                    titulo="Advertencia";
                    message="No se actualizo el registro";
                    break;
                case "en":
                    titulo="Warning";
                    message="No update";
                    break;
                    
            }
            if(exception != null){
                warningDialog(titulo, message, exception);
            }else{
                warningDialog(titulo, message);
            }
                    
            
        } catch (Exception e) {
            warningDialog(nameOfMethod(),e.getLocalizedMessage());
        }
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="warningUpdateDialog(Exception exception,String...languague) ">
    public static void warningEqualsUpdateDialog(String...languague){
        try {
            String translation="es";

            if (languague.length != 0) {
                translation = languague[0];
            }
            translation=translation.toLowerCase();
            String titulo ="Advertencia";
            String message="No hay ningun cambio no sera actualizado el registro";
            switch(translation){
                case "es":
                    titulo="Advertencia";
                    message="No hay ningun cambio no sera actualizado el registro";
                    break;
                case "en":
                    titulo="Warning";
                    message="No change for update";
                    break;
                    
            }
             warningDialog(titulo, message);
            
        } catch (Exception e) {
            warningDialog(nameOfMethod(),e.getLocalizedMessage());
        }
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="warningDialog(String titulo, String texto, Exception e)"> 
    public static void warningDialog(String titulo, String texto, Exception e) {
        String msgExtra=""; 
        if(e==null){
                
                }else{
                   msgExtra =e.getLocalizedMessage();
                }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo,
                texto+ " "+msgExtra);

        PrimeFaces.current().dialog().showMessageDynamic(message);

    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="fatalDialog"> 

    public static void fatalDialog(String titulo, String texto) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo,
                texto);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="errorDialog(String titulo, String texto)"> 

    public static void errorDialog(String titulo, String texto) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                titulo, texto);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="errorDialog(String titulo, String texto, Exception e)"> 

    public static void errorDialog(String titulo, String texto, Exception e) {
          String msgExtra=""; 
        if(e==null){
                
                }else{
                   msgExtra =e.getLocalizedMessage();
                }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                titulo, texto +" "+msgExtra);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }    // </editor-fold>
    
    
      // <editor-fold defaultstate="collapsed" desc="nameOfClassAndMethod()">
    public static String nameOfClassAndMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="nameOfClass()">

    public static String nameOfClass() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length());
    }    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="nameOfMethod(">
    public static String nameOfMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return e.getMethodName();
    }
    // </editor-fold>
}
