
import javax.swing.tree.DefaultMutableTreeNode;

public class LignePrincipale {

  private String nom;
  private TableCaracteristique table;
  private int pRef;
  private DefaultMutableTreeNode noeud;
  private DefaultMutableTreeNode racineCaracteristique;

  public LignePrincipale(int refParent, String name, TableCaracteristique tableC) {
    nom = name;
    table = tableC;
    pRef = refParent;
    noeud = new DefaultMutableTreeNode(nom);
    racineCaracteristique = new DefaultMutableTreeNode(nom);
  }
  public LignePrincipale(int refParent, String name) {
    nom = name;
    pRef = refParent;
    noeud = new DefaultMutableTreeNode(nom);
    racineCaracteristique = new DefaultMutableTreeNode(nom);
  }
  public LignePrincipale(int refParent, String name, String nameAndNumber) {
    nom = name;
    pRef = refParent;
    noeud = new DefaultMutableTreeNode(nameAndNumber);
    racineCaracteristique = new DefaultMutableTreeNode(nom);
  }
  public LignePrincipale(int refParent, String name, TableCaracteristique tableC, String nameAndNumber) {
    nom = name;
    table = tableC;
    pRef = refParent;
    noeud = new DefaultMutableTreeNode(nameAndNumber);
    racineCaracteristique = new DefaultMutableTreeNode(nom);
  }
  public LignePrincipale() {
  }

  public String getNom() {
    return nom;
  }
  public TableCaracteristique getTable() {
    return table;
  }
  public int getReferenceParent() {
    return pRef;
  }
  public DefaultMutableTreeNode getNoeud() {
    return this.noeud;
  }
  public DefaultMutableTreeNode getRacineCaracteristique() {
    return this.racineCaracteristique;
  }

  public void setNom(String name) {
    this.nom = name;
  }
  public void setTable(TableCaracteristique tab) {
    // A ne pas utiliser 
    this.table = tab;
  }
  public void setReferenceParent(int ref) {
    this.pRef = ref;
  }
  public void setNoeud(DefaultMutableTreeNode n) {
    this.noeud = n;
  }
  public void setRacineCaracteristique(DefaultMutableTreeNode n) {
    this.racineCaracteristique = n;
  }

  public void add2Table(int ref, int refParent, String name, boolean t) {

    // Nouvelle ligneC à insérer dans la table de la ligneP 
    LigneCaracteristique ligne = new LigneCaracteristique(refParent, name, t);
    DefaultMutableTreeNode node = ligne.getNoeud();

    // On vérifie qu'il existe déjà une table (?) 
    if (this.table == null) {
      this.table = new TableCaracteristique();
      this.table.put(ref, ligne);
      this.racineCaracteristique.add(node);

    } else {
      this.table.put(ref, ligne);

      if (refParent == 0) {
        this.racineCaracteristique.add(node);

      } else {
        this.getNoeudCaracteristique(refParent).add(node);
      }
    }
  }
  public void add2Table(int ref, int refParent, String name, boolean t, String nameAndNumber) {

    // Nouvelle ligneC à insérer dans la table de la ligneP 
    LigneCaracteristique ligne = new LigneCaracteristique(refParent, name, t, nameAndNumber);
    DefaultMutableTreeNode node = ligne.getNoeud();

    // On vérifie qu'il existe déjà une table (?) 
    if (this.table == null) {
      this.table = new TableCaracteristique();
      this.table.put(ref, ligne);
      this.racineCaracteristique.add(node);

    } else {
      this.table.put(ref, ligne);

      if (refParent == 0) {
        this.racineCaracteristique.add(node);

      } else {
        this.getNoeudCaracteristique(refParent).add(node);
      }
    }
  }

  public DefaultMutableTreeNode getNoeudCaracteristique(int ref) {
    // renvoie le noeud de l'arbre caractéristique stockée à la référence REF 
    LigneCaracteristique lc = (LigneCaracteristique) this.table.get(ref);
    return lc.getNoeud();
  }

  @Override
  public String toString() {
    String statement = "";
    statement += this.getNom() + " | ";
    if (this.getTable() == null) {
      statement += "Pas de table";
    } else {
      statement += "Table";
    }
    statement += " - " + this.getReferenceParent();
    return statement;
  }

}

