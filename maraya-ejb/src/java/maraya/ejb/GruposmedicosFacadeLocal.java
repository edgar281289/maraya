/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.Gruposmedicos;
import maraya.entity.Medicos;

/**
 *
 * @author Portatil
 */
@Local
public interface GruposmedicosFacadeLocal {

    void create(Gruposmedicos gruposmedicos);

    void edit(Gruposmedicos gruposmedicos);

    void remove(Gruposmedicos gruposmedicos);

    Gruposmedicos find(Object id);

    List<Gruposmedicos> findAll();

    List<Gruposmedicos> findRange(int[] range);

    int count();
	
    public List<Gruposmedicos> buscarPacientes(Medicos medico);
    
}
