/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.Cambiomedico;

/**
 *
 * @author Portatil
 */
@Local
public interface CambiomedicoFacadeLocal {

    void create(Cambiomedico cambiomedico);

    void edit(Cambiomedico cambiomedico);

    void remove(Cambiomedico cambiomedico);

    Cambiomedico find(Object id);

    List<Cambiomedico> findAll();

    List<Cambiomedico> findRange(int[] range);

    int count();
    
}
