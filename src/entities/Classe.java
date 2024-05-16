package entities;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private int id;
    private String nomClasse;
    private Filiere filiere;
    private Niveau niveau;
    private List<Cours> listcours = new ArrayList<>();
    private static int nbre;

    public Classe(int id, String nomClasse, Filiere filiere, Niveau niveau, List<Cours> cours) {
        this.id = id;
        this.nomClasse = nomClasse;
        this.filiere = filiere;
        this.niveau = niveau;
        this.listcours = cours;
    }
    public Classe() {
        id = ++ nbre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomClasse() {
        return nomClasse;
    }
    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    public Filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    public Niveau getNiveau() {
        return niveau;
    }
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    public void addData(Cours cours) {
        listcours.add(cours);
        
    }
    public List<Cours> getListCours() {
        return listcours;
    }
    @Override
    public String toString() {
        return "Classe [id=" + id + ", nomClasse=" + nomClasse + ", filiere=" + filiere + ", niveau=" + niveau
                + "]";
    }

    
}
