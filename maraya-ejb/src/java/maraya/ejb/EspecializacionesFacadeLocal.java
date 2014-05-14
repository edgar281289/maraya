/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.Especializaciones;

/**
 *
 * @author Portatil
 */
@Local
public interface EspecializacionesFacadeLocal {

    void create(Especializaciones especializaciones);

    void edit(Especializaciones especializaciones);

    void remove(Especializaciones especializaciones);

    Especializaciones find(Object id);

    List<Especializaciones> findAll();

    List<Especializaciones> findRange(int[] range);

    int count();
    
}
