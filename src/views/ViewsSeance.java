package views;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import core.Views;
import services.ServiceSeance;
import entities.Seance;
import entities.Statut;

public class ViewsSeance extends ViewsH implements Views<Seance> {

    public ViewsSeance() {
    }

    private ServiceSeance serviceSeance;
    
    public ViewsSeance(ServiceSeance serviceSeance) {
        this.serviceSeance = serviceSeance;
    }
    
    public void createdSeance() {
        char choix;
        do{
            Seance seance = new Seance();
            System.out.println("Entrer une date");
            seance.setDate(saisirDate());
            System.out.println("Entrer l'heure de debut du cours");
            seance.setHeureDebut(saisirHeure());
            System.out.println("Entrer l'heure de fin de cours");
            seance.setHeureFin(saisirHeure());
            seance.setStatut(Statut.Planifie);
            seance.setCours(serviceSeance.getCours());
            serviceSeance.getCours().addData(seance);
            System.out.println("Voulez-vous ajouter encore une seance a ce cours[O/N]");
            choix  = sc.next().charAt(0);
        }while(choix == 'O');
        
    }
    
    @Override
    public Seance demande(List<Seance> objeTs) {
        int choix2;
        do{
            System.out.println("Entrer l'id de da seance");
            choix2 = sc.nextInt();   
        }while(serviceSeance.verfId(serviceSeance.getCours(), choix2) == null);
        return serviceSeance.verfId(serviceSeance.getCours(), choix2);
    }


    public static LocalDate saisirDate() {
        int year, month, day;

        System.out.println("Saisissez l'année (YYYY) : ");
        year = sc.nextInt();
        System.out.println("Saisissez le mois (MM) : ");
        month = sc.nextInt();
        System.out.println("Saisissez le jour (DD) : ");
        day = sc.nextInt();

        return LocalDate.of(year, month, day);
    }

    public static LocalTime saisirHeure() {
        int hour, minute;

        System.out.println("Saisissez l'heure (HH) : ");
        hour = sc.nextInt();
        System.out.println("Saisissez les minutes (MM) : ");
        minute = sc.nextInt();

        return LocalTime.of(hour, minute);
    }

    @Override
    public Seance created() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'created'");
    }

    public ServiceSeance getServiceSeance() {
        return serviceSeance;
    }

    public void setServiceSeance(ServiceSeance serviceSeance) {
        this.serviceSeance = serviceSeance;
    }
    
}
