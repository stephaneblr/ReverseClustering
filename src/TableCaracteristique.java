
import java.util.Hashtable;
import java.util.Iterator;

public class TableCaracteristique extends Hashtable {

  public TableCaracteristique() {
    super();
  }

  @Override
  public synchronized String toString() {
    String statement = "TABLE CARACTERISTIQUE\n";

    Iterator itr = this.keySet().iterator();
    while (itr.hasNext()) {
      Object key = itr.next();
      statement += "\t" + key + " - " + this.get(key).toString() + "\n";
    }
    statement += "FIN DE LA TABLE";
    return statement;
  }
}

