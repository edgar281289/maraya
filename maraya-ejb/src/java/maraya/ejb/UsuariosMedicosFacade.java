/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import maraya.entity.UsuariosMedicos;

/**
 *
 * @author Portatil
 */
@Stateless
public class UsuariosMedicosFacade extends AbstractFacade<UsuariosMedicos> implements UsuariosMedicosFacadeLocal {
    @PersistenceContext(unitName = "maraya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosMedicosFacade() {
        super(UsuariosMedicos.class);
    }
    
    public List<UsuariosMedicos> login(String usuario, String password){
        return em.createNamedQuery("UsuariosMedicos.findByUserAndPassword")
                .setParameter("user", usuario)
                .setParameter("password", password)
                .getResultList();
    }
}
