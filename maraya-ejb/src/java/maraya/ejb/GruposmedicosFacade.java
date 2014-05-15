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
import maraya.entity.Gruposmedicos;
import maraya.entity.Medicos;

/**
 *
 * @author Portatil
 */
@Stateless
public class GruposmedicosFacade extends AbstractFacade<Gruposmedicos> implements GruposmedicosFacadeLocal {

    @PersistenceContext(unitName = "maraya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruposmedicosFacade() {
        super(Gruposmedicos.class);
    }

    @Override
    public List<Gruposmedicos> buscarPacientes(Medicos medico) {
        return em.createNamedQuery("Gruposmedicos.findAllPacientes")
                .setParameter("medico1", medico)
                .getResultList();
    }
}
