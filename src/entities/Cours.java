package entities;


import java.util.ArrayList;
import java.util.List;


public class Cours{
    private int id;
    private String module;
    private String professeur;
    private static int nbre;
    private List<Seance> seances = new ArrayList<>();
    private List<Classe> classes = new ArrayList<>();
    private Statut statut;

    
    public Cours() {
        id = ++ nbre;
    }
    public Cours(int id, String module, String professeur, List<Seance> seances,List<Classe> classes, Statut statut) {
        this.id = id;
        this.module = module;
        this.professeur = professeur;
        this.seances = seances;
        this.classes = classes;
        this.statut = statut;
    }
    public int getId() {
        return id;
    }
    public String getModule() {
        return module;
    }
    public String getProfesseur() {
        return professeur;
    }
    public static int getNbre() {
        return nbre;
    }
    public Statut getStatut() {
        return statut;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }
    public static void setNbre(int nbre) {
        Cours.nbre = nbre;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    @Override
    public String toString() {
        return "Cours [id=" + id + ", module=" + module + ", professeur=" + professeur + 
        ", statut=" + statut + "]";
    }
    public void addData(Seance seance) {
        seances.add(seance);
        
    }
    public List<Seance> getSeances() {
        return seances;
    }
    public List<Classe> getClasses() {
        return classes;
    }
    public void addData(Classe classe) {
        classes.add(classe);
        
    }

}
