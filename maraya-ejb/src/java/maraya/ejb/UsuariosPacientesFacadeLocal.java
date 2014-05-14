/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.UsuariosPacientes;

/**
 *
 * @author Portatil
 */
@Local
public interface UsuariosPacientesFacadeLocal {

    void create(UsuariosPacientes usuariosPacientes);

    void edit(UsuariosPacientes usuariosPacientes);

    void remove(UsuariosPacientes usuariosPacientes);

    UsuariosPacientes find(Object id);

    List<UsuariosPacientes> findAll();

    List<UsuariosPacientes> findRange(int[] range);

    int count();
    
	public List<UsuariosPacientes> login(String usuario, String password);
}
