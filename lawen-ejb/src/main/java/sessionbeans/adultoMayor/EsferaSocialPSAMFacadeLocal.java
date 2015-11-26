/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.adultoMayor;

import entities.adultoMayor.EsferaSocialPSAM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface EsferaSocialPSAMFacadeLocal {

    void create(EsferaSocialPSAM esferaSocialPSAM);

    void edit(EsferaSocialPSAM esferaSocialPSAM);

    void remove(EsferaSocialPSAM esferaSocialPSAM);

    EsferaSocialPSAM find(Object id);

    List<EsferaSocialPSAM> findAll();

    List<EsferaSocialPSAM> findRange(int[] range);

    int count();
    
}
