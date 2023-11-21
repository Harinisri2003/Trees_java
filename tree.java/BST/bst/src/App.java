 class BST{
    Node root;
    class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
        }
    }

    BST()
    {
        root=null;
    }
    BST(int val)
    {
        root=new Node(val);
    }

    public void getData(int val)
    {
        insert(root, val) ;
    }

    public Node insert(Node root,int  val)
    {
        if(root==null)
        {
            return new Node(val);
        }
        if(val<root.data)
        {
            root.left=insert(root.left,val);
        }
        else
        {
            root.right=insert(root.right,val);
        }
        return root;
    }
    public void inOrder(Node root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public Node search(Node root,int val)
    {
        if( root==null||root.data==val )
        {
            return root;
        }
        if(val<root.data)
        return search(root.left, val);
        return search(root.right, val);
    }

    public void del(int val)
    {
        root=delete(root, val);
    }

    public Node delete(Node root,int val) //50,20
    {
        if(root==null)
        {
            System.out.println(root);
            return root; //null
        }
        if(val<root.data)  //20<50
        {
            root.left=delete(root.left, val);  //(20,20)  //root.left=10
        }
        else if(val>root.data)
        {
            root.right=delete(root.right, val);
        }
        else{
           if(root.left==null)
           {
            return root.right;
           } 
           else if(root.right==null)
           {
            return root.left;  //10
           }
           root.data=min(root.right); //25
           root.right=delete(root.right, root.data); //(null,25)
           
        }
        return root;
    }
    int min(Node root)
    {
        int minval=root.data;  //25
        while(root.left!=null)
        {
            minval=root.left.data;  //25
            root=root.left;  //null
        }
        return minval;  //25
    }
}


public class App {
    public static void main(String[] args) throws Exception {
       BST tree=new BST(90);
       tree.getData(20);
       tree.getData(10);
       tree.getData(56);
       tree.getData(69);
       tree.getData(5);
       tree.getData(25);
       tree.inOrder(tree.root);
       if(tree.search(tree.root,50)==null)
       {
         System.out.println("not found");
       }
       else
       {
        System.out.println("found");
       }

       tree.del(90);
       tree.inOrder(tree.root);
    }
}
