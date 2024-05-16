package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Seance  {
    private int id;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private static int nbre;
    private Cours cours;
    private Statut statut;
    public Seance() {
        id = ++ nbre;
    }
    public Seance(int id, LocalDate date, LocalTime heureDebut, LocalTime heureFin, Cours cours, Statut statut) {
        this.id = id;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.cours = cours;
        this.statut = statut;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }
    public LocalTime getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }
    public static int getNbre() {
        return nbre;
    }
    public static void setNbre(int nbre) {
        Seance.nbre = nbre;
    }
    public Cours getCours() {
        return cours;
    }
    public void setCours(Cours cours) {
        this.cours = cours;
    }
    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    @Override
    public String toString() {
        return "Seance [id=" + id + ", date=" + date + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin
                +  ", statut=" + statut + "]";
    }
    @Override
    public Seance clone() throws CloneNotSupportedException {
        return new Seance(this.id, this.date, this.heureDebut, this.heureFin, this.cours, this.statut);
    }
    
}
