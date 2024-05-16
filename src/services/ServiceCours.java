package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Classe;
import entities.Cours;

public class ServiceCours implements Service<Cours>{
    private List<Cours> listcours = new ArrayList<>();

    @Override
    public boolean save(Cours objet) {
        if (objet != null) {
            listcours.add(objet);
            return true;
        }
        return false;
    }


    @Override
    public List<Cours> show() {
        return listcours;
    }
    


    @Override
    public void liste(Cours obList) {
        for(Classe  tab : obList.getClasses()){
            if(tab!=null){
                System.out.println(tab.toString());
            }  
        }
    }


    @Override
    public Cours verfId(List<Cours> objeTs, int id) {
        for (Cours obejeT : objeTs) {
            if (obejeT.getId() == id) {
                return obejeT;
            }
        }
        return null;
    }


    @Override
    public void liste(List<Cours> listcours) {
        for(Cours tab : listcours){
            if(tab!=null){
                System.out.println(tab.toString());
            } 
        } 
    }


    


    
    
}
