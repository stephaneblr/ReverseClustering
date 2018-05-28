
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.LinkedList;
import java.util.Iterator;

public class Structure extends JFrame {

  private final String racinePrincipale = "(0) Général";
  private int refCourante = 1;
  private TablePrincipale tablePrincipale = new TablePrincipale();
  private DefaultMutableTreeNode root = new DefaultMutableTreeNode(racinePrincipale);

  public void addPrincipal(int refParent, String nom) {
    // Rajoute un fils dans la taxonomie 

    String nameAndNumber = "(" + String.valueOf(refCourante) + ") " + nom;

    if (this.tablePrincipale.get(refParent) == null) {

      LignePrincipale ligne = new LignePrincipale(refParent, nom, nameAndNumber);
      tablePrincipale.put(refCourante, ligne);
      refCourante++;

      root.add(ligne.getNoeud());

    } else {
      LignePrincipale lp = (LignePrincipale) this.tablePrincipale.get(refParent);
      TableCaracteristique table = lp.getTable();
      LignePrincipale ligne = new LignePrincipale(refParent, nom, table, nameAndNumber);
      tablePrincipale.put(refCourante, ligne);
      refCourante++;

      DefaultMutableTreeNode knot = lp.getNoeud();
      knot.add(ligne.getNoeud());

    }
  }
  public void addCaracteristique(int refPrincipale, int refParent, String name, boolean t) {

    LinkedList<Integer> liste = this.getDescendants(refPrincipale);
    String nameAndNumber = "(" + String.valueOf(refCourante) + ") " + name;

    LignePrincipale l = (LignePrincipale) this.tablePrincipale.get(refPrincipale);
    l.add2Table(refCourante, refParent, name,t , nameAndNumber);

    for (Integer ref : liste) {
      LignePrincipale lk = (LignePrincipale) this.tablePrincipale.get(ref);
      lk.add2Table(refCourante, refParent, name, t, nameAndNumber);
    }

    refCourante++;
  }

  public int getParent(int ref) {
    LignePrincipale l = (LignePrincipale) this.tablePrincipale.get(ref);
    return l.getReferenceParent();
  }
  public LinkedList<Integer> getEnfants(int i) {
    // Liste de tous les enfants, impactés par l'ajout d'une caractéristique 

    LinkedList<Integer> liste = new LinkedList<Integer>();

    Iterator itr = this.tablePrincipale.keySet().iterator();
    while (itr.hasNext()) {

      Object key = itr.next();
      LignePrincipale lp = (LignePrincipale) this.tablePrincipale.get(key);

      int intermediaire = lp.getReferenceParent();
      if (intermediaire == i) {
        liste.add((int) key);
      }
    }

    return liste;
  }
  public LinkedList<Integer> getDescendants(int i) {

    LinkedList<Integer> listeComplete = new LinkedList<Integer>();

    // Attention, ne recherche que jusqu'à la 10ème génération 
    LinkedList<Integer> enfants1 = this.getEnfants(i);
    if (enfants1.size() != 0) {
      for (int enfant1 : enfants1) {
        listeComplete.add(enfant1);
        LinkedList<Integer> enfants2 = this.getEnfants(enfant1);
        if (enfants2.size() != 0) {
          for (int enfant2 : enfants2) {
            listeComplete.add(enfant2);
            LinkedList<Integer> enfants3 = this.getEnfants(enfant2);
            if (enfants3.size() != 0) {
              for (int enfant3 : enfants3) {
                listeComplete.add(enfant3);
                LinkedList<Integer> enfants4 = this.getEnfants(enfant3);
                if (enfants4.size() != 0) {
                  for (int enfant4 : enfants4) {
                    listeComplete.add(enfant4);
                    LinkedList<Integer> enfants5 = this.getEnfants(enfant4);
                    if (enfants5.size() != 0) {
                      for (int enfant5 : enfants5) {
                        listeComplete.add(enfant5);
                        LinkedList<Integer> enfants6 = this.getEnfants(enfant5);
                        if (enfants6.size() != 0) {
                          for (int enfant6 : enfants6) {
                            listeComplete.add(enfant6);
                            LinkedList<Integer> enfants7 = this.getEnfants(enfant6);
                            if (enfants7.size() != 0) {
                              for (int enfant7 : enfants7) {
                                listeComplete.add(enfant7);
                                LinkedList<Integer> enfants8 = this.getEnfants(enfant7);
                                if (enfants8.size() != 0) {
                                  for (int enfant8 : enfants8) {
                                    listeComplete.add(enfant8);
                                    LinkedList<Integer> enfants9 = this.getEnfants(enfant8);
                                    if (enfants9.size() != 0) {
                                      for (int enfant9 : enfants9) {
                                        listeComplete.add(enfant9);
                                        LinkedList<Integer> enfants10 = this.getEnfants(enfant9);
                                        if (enfants10.size() != 0) {
                                          for (int enfant10 : enfants10) {
                                            listeComplete.add(enfant10);
                                            // FIN 
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return listeComplete;
  }

  public String afficher(int ref) {
    // A améliorer ! 
    LignePrincipale lp = (LignePrincipale) this.tablePrincipale.get(ref);
    TableCaracteristique tab = (TableCaracteristique) lp.getTable();
    return tab.toString();
  }

  public Tree arbre() {
    DefaultMutableTreeNode racine = this.root;
    return new TreeTaxonomy(racine, "Taxonomie");
  }
  public Tree arbre(int i) {
    LignePrincipale lp = (LignePrincipale) this.tablePrincipale.get(i);
    DefaultMutableTreeNode racine = lp.getRacineCaracteristique();
    return new TreeSpecifications(racine, lp.getNom());
  }

  @Override
  public String toString() {
    return this.tablePrincipale.toString();
  }

}
