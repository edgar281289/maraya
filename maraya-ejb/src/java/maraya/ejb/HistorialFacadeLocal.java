/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.Historial;

/**
 *
 * @author Portatil
 */
@Local
public interface HistorialFacadeLocal {

    void create(Historial historial);

    void edit(Historial historial);

    void remove(Historial historial);

    Historial find(Object id);

    List<Historial> findAll();

    List<Historial> findRange(int[] range);

    int count();
    
	public List<Historial> buscarHistorial(Long id);
}
