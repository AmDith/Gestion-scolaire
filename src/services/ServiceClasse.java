package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Classe;
import entities.Cours;
import entities.Niveau;
import entities.Filiere;

public class ServiceClasse implements Service<Classe>{
    private List<Classe> classes = new ArrayList<>(); 
    @Override
    public boolean save(Classe objet) {
        if (objet != null) {
            classes.add(objet);
            return true;
        }
        return false;
    }

    @Override
    public List<Classe> show() {
        return classes;
    }

    public String generateName(Niveau niveau,Filiere filiere) {
        return String.valueOf(niveau) + String.valueOf(filiere);
    }

    @Override
    public void liste(Classe obList) {
        for(Cours  tab : obList.getListCours()){
            if(tab!=null){
                System.out.println(tab.toString());
            }  
        }
    }

    @Override
    public Classe verfId(List<Classe> objeTs, int id) {
        for (Classe obejeT : objeTs) {
            if (obejeT.getId() == id) {
                return obejeT;
            }
        }
        return null;
    }

    @Override
    public void liste(List<Classe> classes) {
        for(Classe tab : classes){
            if(tab!=null){
                System.out.println(tab.toString());
            } 
        }   
        
    }

    
    
}
