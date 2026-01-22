package minimarketdemo.controller.auditoria;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.AudBitacora;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemoFactEJB.model.entities.VwEvento;
import minimarketdemoFactEJB.model.managers.ManagerEventoFact;

@Named
@SessionScoped
public class BeanAudBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private ManagerAuditoria managerAuditoria;
    private List<AudBitacora> listaBitacora;
    private Date fechaInicio;
    private Date fechaFin;

    private List<VwEvento> listaVwEventos;
    @EJB
    private ManagerEventoFact managerEventoFact;

    public BeanAudBitacora() {

    }

    @PostConstruct
    public void inicializacion() {

    }

    public String actionCargarMenuBitacora() {
        // obtener la fecha de ayer:
        fechaInicio = ModelUtil.addDays(new Date(), -1);
        // obtener la fecha de hoy:
        fechaFin = new Date();
        listaBitacora = managerAuditoria.findBitacoraByFecha(fechaInicio, fechaFin);
        JSFUtil.crearMensajeINFO("Registros encontrados: " + listaBitacora.size());
        return "bitacora";
    }

    public void actionListenerConsultarBitacora() {
        listaBitacora = managerAuditoria.findBitacoraByFecha(fechaInicio, fechaFin);
        JSFUtil.crearMensajeINFO("Registros encontrados: " + listaBitacora.size());
    }

    public String actionCargarMenuEventos() {
        listaVwEventos=managerEventoFact.findAllVwEvento();
        return "eventos";
    }

    public List<AudBitacora> getListaBitacora() {
        return listaBitacora;
    }

    public void setListaBitacora(List<AudBitacora> listaBitacora) {
        this.listaBitacora = listaBitacora;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<VwEvento> getListaVwEventos() {
        return listaVwEventos;
    }

    public void setListaVwEventos(List<VwEvento> listaVwEventos) {
        this.listaVwEventos = listaVwEventos;
    }

}
