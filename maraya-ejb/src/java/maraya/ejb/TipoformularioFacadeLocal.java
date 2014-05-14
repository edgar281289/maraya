/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maraya.ejb;

import java.util.List;
import javax.ejb.Local;
import maraya.entity.Tipoformulario;

/**
 *
 * @author Portatil
 */
@Local
public interface TipoformularioFacadeLocal {

    void create(Tipoformulario tipoformulario);

    void edit(Tipoformulario tipoformulario);

    void remove(Tipoformulario tipoformulario);

    Tipoformulario find(Object id);

    List<Tipoformulario> findAll();

    List<Tipoformulario> findRange(int[] range);

    int count();
    
}
