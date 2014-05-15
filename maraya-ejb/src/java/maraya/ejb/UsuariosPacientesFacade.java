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
import maraya.entity.UsuariosPacientes;

/**
 *
 * @author Portatil
 */
@Stateless
public class UsuariosPacientesFacade extends AbstractFacade<UsuariosPacientes> implements UsuariosPacientesFacadeLocal {
    @PersistenceContext(unitName = "maraya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosPacientesFacade() {
        super(UsuariosPacientes.class);
    }
    
    public List<UsuariosPacientes> login(String usuario, String password){
            return em.createNamedQuery("UsuariosPacientes.findByUserAndPassword")
                    .setParameter("user", usuario)
                    .setParameter("password", password)
                    .getResultList();
    }
}
