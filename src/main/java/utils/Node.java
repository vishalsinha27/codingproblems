package utils;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Node {

  public Node() {
    
  }
  public Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left ;
    this.right = right ;
  }
  public int data ;
  public Node left ;
  public Node right ;
  
  /*
   * 10 20 L 10 30 R 20 40 L 20 60 R

   */
  public static Node createBinaryTree(String data) {
    String[] dt = data.trim().split(" ") ;
    int length = dt.length ;
    Node root   = new Node()  ;
    root.data = Integer.parseInt(dt[0]) ;
    LinkedHashMap<Integer, Node> map = new LinkedHashMap<Integer, Node>() ;
    map.put(root.data, root) ;
    Node first = root ;
    Node second = null ;
    for(int i = 1;i<length;i++) {
      String d= dt[i].trim();
      if(first == null) {
        first = map.get(Integer.parseInt(d)) ;
        continue ;
      }
      if(second==null)
      {
        second = new Node() ;
        second.data = Integer.parseInt(d) ;
        continue ;
      }
      
      
      if(first!=null && second!=null) {
        if("L".equalsIgnoreCase(d)) {
          first.left = second ;
        } else if("R".equalsIgnoreCase(d)) {
          first.right = second ;
        }
        map.put(second.data, second) ;
        second = null ;
        first = null ;
      }
      
      
    }
    return root ;
  }
  
  public static void preOrderTraversal(Node root) {
    if(root==null) {
      return ;
    }
    System.out.print(root.data+",");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }
  
  public static void main(String[] args) {
    String data = "10 20 L 10 30 R 20 40 L 40 60 L 40 80 R 80 100 R 100 120 R" ;
    Node root = createBinaryTree(data);
    preOrderTraversal(root);
  }
}
