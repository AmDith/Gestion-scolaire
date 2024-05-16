package services;
import java.time.LocalDate;
import java.util.List;

import core.Seanceimp;
import entities.Classe;
import entities.Cours;
import entities.Seance;
import entities.Statut;


public class ServiceSeance implements Seanceimp<Seance,Cours,Classe> {
    private Cours cours;

    public ServiceSeance() {
    }




    public ServiceSeance(Cours cours) {
        this.cours = cours;
    }
    

    

    @Override
    public List<Seance> show() {
        return cours.getSeances();
    }


    @Override
    public Seance verfId(Cours cours, int id) {
        for (Seance obejeT : cours.getSeances()) {
            if (obejeT.getId() == id) {
                return obejeT;
            }
        }
        return null;
    }

    public Cours getCours() {
        return cours;
    }

    public void changeStatut(Seance seance,Statut statut) {
        seance.setStatut(statut);
    }



    @Override
    public void liste(Cours objeTs, Statut statut) {
        for(Seance tab : objeTs.getSeances()){
            if(tab!=null && tab.getStatut().equals(statut)){
                System.out.println(tab.toString());
            } 
        } 
    }



    @Override
    public void liste(Cours objeTs, LocalDate date) {
        for(Seance tab : objeTs.getSeances()){
            if(tab!=null && tab.getDate().equals(date)){
                System.out.println(tab.toString());
            } 
        }
    }



    



    
    
}
