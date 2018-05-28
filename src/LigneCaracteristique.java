
import javax.swing.tree.DefaultMutableTreeNode;

public class LigneCaracteristique {

  private String nom;
  private boolean var;
  private int pRef;
  private DefaultMutableTreeNode noeud;

  public LigneCaracteristique(int pR, String name, boolean t) {
    nom = name;
    var = t;
    pRef = pR;
    noeud = new DefaultMutableTreeNode(nom);
  }
  public LigneCaracteristique(int pR, String name, boolean t, String nameAndNumber) {
    nom = name;
    var = t;
    pRef = pR;
    noeud = new DefaultMutableTreeNode(nameAndNumber);
  }

  public String getNom() {
    return nom;
  }
  public boolean estVariable() {
    return var;
  }
  public int getReferenceParent() {
    return pRef;
  }
  public DefaultMutableTreeNode getNoeud() {
    return this.noeud;
  }

  public void setNom(String name) {
    this.nom = name;
  }
  public void variable() {
    this.var = true;
  }
  public void nonVariable() {
    this.var = false;
  }
  public void setReferenceParent(int ref) {
    this.pRef = ref;
  }
  public void setNoeud(DefaultMutableTreeNode knot) {
    this.noeud = knot;
  }

  @Override
  public String toString() {
    String statement = "";
    statement += this.getNom() + " | " + this.var + " - " + this.getReferenceParent();
    return statement;
  }
}

