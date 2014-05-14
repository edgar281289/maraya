/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maraya.entity.Medicos;

/**
 *
 * @author Portatil
 */
@Stateless
public class MedicosFacade extends AbstractFacade<Medicos> implements MedicosFacadeLocal {
    @PersistenceContext(unitName = "maraya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicosFacade() {
        super(Medicos.class);
    }
    
}
