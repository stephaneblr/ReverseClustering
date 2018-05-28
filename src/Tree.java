
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree extends JFrame {

  private JTree tree;

  public Tree() {
  }
  public Tree(DefaultMutableTreeNode racine, String titre) {

    tree = new JTree(racine);
    add(tree);

    for (int i = 0; i < tree.getRowCount(); i++) {
      tree.expandRow(i);
    }

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setTitle(titre);
    this.pack();
    this.setSize(400, 400);
    this.setLocationRelativeTo(null);

    this.setVisible(true);

  }


}

