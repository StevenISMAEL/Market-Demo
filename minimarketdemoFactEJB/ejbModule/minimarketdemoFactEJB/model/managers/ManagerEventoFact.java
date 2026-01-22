package minimarketdemoFactEJB.model.managers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import minimarketdemoFactEJB.model.entities.VwEvento;

/**
 * Session Bean implementation class ManagerEventoFact
 */
@Stateless
@LocalBean
public class ManagerEventoFact {

    @PersistenceContext
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerEventoFact() {

    }
    public List<VwEvento> findAllVwEvento(){
        return em.createNamedQuery("VwEvento.findAll", VwEvento.class).getResultList();
    }
}
