/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Medicamentos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sessionbeans.MedicamentosFacadeLocal;

/**
 *
 * @author Beban
 */
@Named(value = "medicamentosController")
@Dependent
public class MedicamentosController {

    @EJB
    private MedicamentosFacadeLocal medicamentosFacade;
    private List<Medicamentos> items = null;
    private List<Medicamentos> selected;
    private List<Medicamentos> allitems =null;
    private List<String> nombres =null;
    private List<String> selectedIds = null;  

    /**
     * Creates a new instance of MedicamentosController
     */
    public MedicamentosController() {
    }

    public List<String> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(List<String> selectedIds) {
        this.selectedIds = selectedIds;
    }

    public void create(Medicamentos medicamentos) {
        medicamentosFacade.create(medicamentos);
    }

    public void edit(Medicamentos medicamentos) {
        medicamentosFacade.edit(medicamentos);
    }

    public void remove(Medicamentos medicamentos) {
        medicamentosFacade.remove(medicamentos);
    }

    public Medicamentos find(Object id) {
        return medicamentosFacade.find(id);
    }

    public List<Medicamentos> findAll() {
        return medicamentosFacade.findAll();
    }

    public List<Medicamentos> findRange(int[] range) {
        return medicamentosFacade.findRange(range);
    }

    public int count() {
        return medicamentosFacade.count();
    }

    public MedicamentosFacadeLocal getMedicamentosFacade() {
        return medicamentosFacade;
    }

    public void setMedicamentosFacade(MedicamentosFacadeLocal medicamentosFacade) {
        this.medicamentosFacade = medicamentosFacade;
    }

    public List<Medicamentos> getItems() {
        return items;
    }

    public void setItems(List<Medicamentos> items) {
        this.items = items;
    }

    public List<Medicamentos> getSelected() {
        return selected;
    }

    public void setSelected(List<Medicamentos> selected) {
        this.selected = selected;
    }

 
    public List<String> getNombres() {
        int i = 0;
        allitems = getFacade().findAll();
        nombres = new ArrayList<String>();
        for (Medicamentos objetos : allitems) {
            nombres.add(objetos.getNombre());
            i++;
        }
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }

    public List<Medicamentos> getAllitems() {
        int i = 0;
        allitems = getFacade().findAll();
        items = new ArrayList<>();
        for (Medicamentos objetos : allitems) {
            items.add(objetos);
            i++;
        }

        return items;
    }

    public void setAllitems(List<Medicamentos> allitems) {
        this.allitems = allitems;
    }

    private MedicamentosFacadeLocal getFacade() {
        return medicamentosFacade;
    }

    Medicamentos getMedicamento(Long valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
