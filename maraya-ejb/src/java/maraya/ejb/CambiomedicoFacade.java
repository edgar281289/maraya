/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maraya.entity.Cambiomedico;

/**
 *
 * @author Portatil
 */
@Stateless
public class CambiomedicoFacade extends AbstractFacade<Cambiomedico> implements CambiomedicoFacadeLocal {
    @PersistenceContext(unitName = "maraya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CambiomedicoFacade() {
        super(Cambiomedico.class);
    }
    
}
