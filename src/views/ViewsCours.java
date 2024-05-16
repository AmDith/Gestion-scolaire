package views;

import java.util.List;

import core.Views;
import entities.Classe;
import entities.Cours;
import services.ServiceClasse;
import services.ServiceCours;
import entities.Statut;

public class ViewsCours extends ViewsH implements Views<Cours> {
    private ServiceCours serviceCours;
    private ServiceClasse serviceClasse;
    private ViewsClasse viewsClasse;
    
    public ViewsCours(ServiceCours serviceCours, ViewsClasse viewsClasse,ServiceClasse serviceClasse) {
        this.serviceCours = serviceCours;
        this.serviceClasse = serviceClasse;
        this.viewsClasse = viewsClasse;
    }

    @Override
    public Cours created() {
       char choix;
       Classe classe;
       Cours cours = new Cours();
       System.out.println("Entrer le nom du module");
       sc.nextLine();
       cours.setModule(sc.nextLine());
       System.out.println("Entrer le nom du prof");
       cours.setProfesseur(sc.nextLine());
       do{
        System.out.println("Voulez-vous ajouter une ou des classe(s) au cours[O/N]");
        choix  = sc.next().charAt(0);
        if(choix == 'O') {
            sc.nextLine();
            if(serviceClasse.show() != null) {
                classe = viewsClasse.demande(serviceClasse.show());
                cours.addData(classe);
                classe.addData(cours);
                cours.setStatut(Statut.Planifie);
                
            }
            else {
                if(serviceClasse.save(viewsClasse.created())) {
                    System.out.println("La classe est cree");
                }
                else {
                    System.out.println("La classe n'est pas cree"); 
                }
            }
            
        }
       }while(choix == 'O');
       return cours;
    }

    @Override
    public Cours demande(List<Cours> objeTs) {
        int choix2;
        do{
            System.out.println("Entrer l'id du cours");
            choix2 = sc.nextInt();   
        }while(serviceCours.verfId(serviceCours.show(), choix2) == null);
        return serviceCours.verfId(serviceCours.show(), choix2);
    }
    
}
