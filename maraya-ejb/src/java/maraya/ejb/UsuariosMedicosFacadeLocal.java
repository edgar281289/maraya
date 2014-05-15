/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.UsuariosMedicos;

/**
 *
 * @author Portatil
 */
@Local
public interface UsuariosMedicosFacadeLocal {

    void create(UsuariosMedicos usuariosMedicos);

    void edit(UsuariosMedicos usuariosMedicos);

    void remove(UsuariosMedicos usuariosMedicos);

    UsuariosMedicos find(Object id);

    List<UsuariosMedicos> findAll();

    List<UsuariosMedicos> findRange(int[] range);

    int count();
    
	public List<UsuariosMedicos> login(String usuario, String password);
}
