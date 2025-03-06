import java.util.List;
import java.util.Map;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   * @param <T>
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static <T> void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) {
      return;
    } 

    System.out.println(root);
    List<Integer> children = tree.get(root);
    
    for (var node : children) {
      preOrder(tree, node);
    }
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) { 
    int minVal = Integer.MAX_VALUE;
    if(root == null) return minVal;
    if(root.value < minVal) minVal = root.value;
    for (Node<Integer> node : root.children) {
      if(node.value < minVal){
        minVal = node.value;
      }

      int minNode = minVal(node); 

      if(minNode < minVal){
        minVal = minNode;
      }
    }  

    return minVal;

  }
  
}
