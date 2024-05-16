import java.util.Scanner;

import entities.Classe;
import entities.Cours;
import entities.Statut;
import services.ServiceClasse;
import services.ServiceCours;
import services.ServiceSeance;
import views.ViewsClasse;
import views.ViewsCours;
import views.ViewsSeance;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ServiceClasse sClasse = new ServiceClasse();
        ServiceCours sCours = new ServiceCours();
        ServiceSeance seance = new ServiceSeance();
        ViewsClasse vc = new ViewsClasse(sClasse);
        ViewsCours vCours = new ViewsCours(sCours, vc, sClasse);
        ViewsSeance vSeance = new ViewsSeance();
        ViewsClasse.setSc(sc);
        ViewsCours.setSc(sc);
        ViewsSeance.setSc(sc);
        int choix;
        Cours cours;
        Classe classe;
        do{
            choix = affichageMenu();
            switch (choix) {
                case 1 :
                    if(sClasse.save(vc.created())) {
                        System.out.println("La classe est cree");
                    }
                    else {
                        System.out.println("La classe n'est pas cree"); 
                    }
                    break;
                case 2 :
                    if(sClasse.show() != null){
                        sClasse.liste(sClasse.show());
                    }
                    break;
                case 3 : 
                    if(sCours.save(vCours.created())) {
                        System.out.println("Le cours est cree");
                    }
                    else {
                        System.out.println("Le cours n'est pas cree"); 
                    }
                    break; 
                case 4 :
                    if(sCours.show() != null){
                        sCours.liste(sCours.show());
                    }
                    break;
                case 5 :
                    sClasse.liste(vc.demande(sClasse.show())); 
                    break;
                case 6 :
                    sCours.liste(vCours.demande(sCours.show())); 
                    break;   
                case 7 :
                    ServiceSeance sea = new ServiceSeance(vCours.demande(sCours.show()));
                    ViewsSeance vs = new ViewsSeance(sea);
                    vs.createdSeance();
                    break;
                case 8 : 
                    cours = vCours.demande(sCours.show());
                    if(cours.getSeances() != null){
                        seance.changeStatut(vSeance.demande(cours.getSeances()), dStatut());
                    }
                    break;
                    
                case 9 :
                    cours = vCours.demande(sCours.show());
                    if(cours.getSeances() != null){
                        seance.liste(cours, dStatut());
                    }
                    break;
                case 10 :
                    cours = vCours.demande(sCours.show());
                    if(cours.getSeances() != null){
                       seance.liste(cours, ViewsSeance.saisirDate());
                    }
                    break;
                case 11 : 
                    classe = vc.demande(sClasse.show());
                    cours = vCours.demande(classe.getListCours());
                    if(cours.getSeances() != null){
                        seance.liste(cours, ViewsSeance.saisirDate());
                     }
                     break;
                default:               
            }

        }while(choix != 12);
        
    }

    public static int affichageMenu(){
        int choix;
        do{
            System.out.println("Menu");
            System.out.println("1-Créer une classe");
            System.out.println("2-Lister les Classe");
            System.out.println("3-Créer un Cours");
            System.out.println("4-Lister Tous les cours");
            System.out.println("5-Lister Tous les cours d'une classe");
            System.out.println("6-Lister La  ou les  classe(s) d'un cours");
            System.out.println("7- Créer une ou des Séance(s) à un cours");
            System.out.println("8- Changer le statut d'une séance de cours");
            System.out.println("9-Lister les séances d'un cours   par Statut");
            System.out.println("10-Lister Les séances de cours de la journée");
            System.out.println("11-Lister les séances de cours d'une classe de la journée");
            System.out.println("12-Quitter");
            System.out.println("Entrez votre choix");
            choix = sc.nextInt();
        }while(choix<0 || choix>12);
        return choix;
        
    }
    public static Statut dStatut() {
        int choix2;
        do{
            System.out.println("---Statut de la seance---");
            System.out.println("1-Planifie");
            System.out.println("2-Encours");
            System.out.println("3-Termine");
            choix2 = sc.nextInt();
        }while(choix2 < 1 || choix2 > 3);
        return Statut.values()[choix2 - 1];
    }
}
