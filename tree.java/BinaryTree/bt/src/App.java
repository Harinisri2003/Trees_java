
class BinaryTree{
  Node root;
  class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
    this.data=data;
    left=null;
    right=null;
  }
  }
  public BinaryTree(int d)
  {
    root=new Node(d);
  }

  public void insertLeft(Node r,int val)
  {
    Node newnode = new Node(val);
    r.left=newnode;
  }
  public void insertRight(Node r,int val)
  {
    Node newnode = new Node(val);
    r.right=newnode;
  }
  public static void preOrder(Node root)
  {
    if(root!=null)
    {
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
    }
  }
  public static void inOrder(Node root)
  {
    if(root!=null)
    {
    inOrder(root.left);
    System.out.println(root.data);
    inOrder(root.right);
    }
  }
  public static void postOrder(Node root)
  {
    if(root!=null)
    {
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.data);
    }
  }
}



public class App {
    public static void main(String[] args) throws Exception {
       BinaryTree tree=new BinaryTree(10);
       tree.insertLeft(tree.root,5);
       tree.insertRight(tree.root,15);
       tree.insertLeft(tree.root.left, 3);
       tree.insertRight(tree.root.left, 8);
       tree.insertLeft(tree.root.right, 12);
       tree.insertRight(tree.root.right, 18);
       System.out.println("preorder:");
       tree.preOrder(tree.root);
       System.out.println("Inorder:");
       tree.inOrder(tree.root);
       System.out.println("postorder:");
       tree.postOrder(tree.root);
    }
}
