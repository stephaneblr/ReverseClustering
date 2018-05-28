
import java.util.Hashtable;
import java.util.Iterator;

public class TablePrincipale extends Hashtable {


  public TablePrincipale() {
    super();
  }

  @Override
  public synchronized String toString() {
    String statement = "TABLE PRINCIPALE\n";

    Iterator itr = this.keySet().iterator();
    while (itr.hasNext()) {
      Object key = itr.next();
      statement += "\t" + key + " - " + this.get(key).toString() + "\n";
    }
    statement += "FIN DE LA TABLE";
    return statement;
  }
}
