/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.RegistroHistorial;

/**
 *
 * @author Portatil
 */
@Local
public interface RegistroHistorialFacadeLocal {

    void create(RegistroHistorial registroHistorial);

    void edit(RegistroHistorial registroHistorial);

    void remove(RegistroHistorial registroHistorial);

    RegistroHistorial find(Object id);

    List<RegistroHistorial> findAll();

    List<RegistroHistorial> findRange(int[] range);

    int count();
    
}
