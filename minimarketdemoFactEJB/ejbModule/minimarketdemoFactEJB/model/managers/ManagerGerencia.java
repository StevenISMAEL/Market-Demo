package minimarketdemoFactEJB.model.managers;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import minimarketdemoFactEJB.model.entities.*;

@Stateless
@LocalBean
public class ManagerGerencia {

    @PersistenceContext(unitName = "facturacionmarketdemoDS")
    private EntityManager em;

    public List<VwFacturasAnio> findFacturasPorAnio() {
        return em.createQuery("SELECT v FROM VwFacturasAnio v ORDER BY v.anio DESC", VwFacturasAnio.class).getResultList();
    }

    public List<VwFacturasMes> findFacturasPorMes() {
        return em.createQuery("SELECT v FROM VwFacturasMes v ORDER BY v.mes ASC", VwFacturasMes.class).getResultList();
    }

    public List<VwPedidosResumen> findPedidosResumen() {
        return em.createQuery("SELECT v FROM VwPedidosResumen v ORDER BY v.mes ASC", VwPedidosResumen.class).getResultList();
    }
}