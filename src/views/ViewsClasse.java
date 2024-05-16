package views;

import java.util.List;

import core.Views;
import entities.Classe;
import entities.Filiere;
import entities.Niveau;
import services.ServiceClasse;

public class ViewsClasse extends ViewsH implements Views<Classe> {
    private ServiceClasse serviceClasse;
    
    public ViewsClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }
   
    public static Niveau getNiveau()  {
        int choix;
        do {
            System.out.println("Quel est votre niveau d'étude ?");
            System.out.println("1-L1");
            System.out.println("2-L2");
            System.out.println("3-L3");
            System.out.println("4-Master");
            
            choix = sc.nextInt();
        } while (choix < 1 || choix > 4);
        return Niveau.values()[choix - 1];
    }

    
    public static Filiere getFiliere() {
        int choix;
        do {
            System.out.println("Quelle est votre filiere ?");
            System.out.println("1-MAE");
            System.out.println("2-IAGE");
            System.out.println("3-GRLS");
            System.out.println("4-ETSE");
            
            choix = sc.nextInt();
        } while (choix < 1 || choix > 4);
        return Filiere.values()[choix - 1];
    }

    

    @Override
    public Classe created() {
        Classe classe = new Classe();
        Niveau niveau = getNiveau();
        Filiere filiere = getFiliere();
        classe.setFiliere(filiere);
        classe.setNiveau(niveau);
        classe.setNomClasse(this.serviceClasse.generateName(niveau, filiere));
        return classe;
    }

    @Override
    public Classe demande(List<Classe> objeTs) {
        int choix2;
        do{
            System.out.println("Entrer l'id de la classe");
            choix2 = sc.nextInt();   
        }while(this.serviceClasse.verfId(this.serviceClasse.show(), choix2) == null);
        return this.serviceClasse.verfId(this.serviceClasse.show(), choix2);
    }

    



    
    
}
