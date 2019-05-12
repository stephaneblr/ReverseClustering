
import javax.swing.SwingUtilities;

public class FichierDeTravail {
  public static void main(String[] args) {
    final Structure s = new Structure();

    // Taxonomie 
    s.addPrincipal(0, "Construction");
    s.addPrincipal(0, "Travaux");
    s.addPrincipal(1, "Logement");
    s.addPrincipal(1, "Commerce");
    s.addPrincipal(1, "Industriel ou agricole");
    s.addPrincipal(2, "Renovation");
    s.addPrincipal(2, "Piscine");
    s.addPrincipal(3, "Logement individuel");
    s.addPrincipal(3, "Logement groupé");
    s.addPrincipal(5, "Industriel");
    s.addPrincipal(5, "Agricole");
    s.addPrincipal(6, "Autre");
    s.addPrincipal(6, "Travaux d'isolation");
    s.addPrincipal(13, "Travaux d'isolation par l'extérieur");
    // s.addPrincipal(int refParent, string nom) 


    // Caractéristiques 
    s.addCaracteristique(14, 0, "Epaisseur", false);
    s.addCaracteristique(14, 15, "Sur-épaisseur mur nord", true);
    s.addCaracteristique(3, 0, "Terrain", false);
    s.addCaracteristique(3, 17, "Existant avant PLU", true);
    s.addCaracteristique(1, 0, "Permis de construire", false);
    s.addCaracteristique(1, 19, "Permis approuvé", true);
    s.addCaracteristique(1, 19, "Date de depot", true);
    // s.addCaracteristique(int refProjet, int refParent, string nom, Type t) 




    // ------------------------------------------------------------------------------------------------------- 

    // POUR VISUALISER LES ARBORESCENCES 
    System.out.println(s);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        s.arbre(14);
        // s.arbre() --> Taxonomie 
        // s.arbre(i) --> Caractéristique du projet i 
      }
    });
  }
}

