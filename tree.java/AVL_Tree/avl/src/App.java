class AVL{
    Node node;
    class Node{
        int data;
        Node left,right;
        int height;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
            height=0;
        }
    }

    AVL()
    {
        node=null;
    }
    AVL(int val)
    {
        node=new Node(val);
    }

    public void getData(int val)
    {
        node=insert(node, val) ;
    }

    public Node insert(Node node,int  val)
    {
        if(node==null)
        {
            return new Node(val);
        }
        if(val<node.data)
        {
            node.left=insert(node.left,val);
        }
        else if(val>node.data)
        {
            node.right=insert(node.right,val);
        }
        else
        return node;
        
        node.height=1+max(getHeight(node.left),getHeight(node.right));
        //to find height of nodes
        // if(val==40)
        // {
        //     System.out.println("Height of node "+node.data+" is updated as "+node.height);
        // }
        int balFactor=getBalanceFactor(node);
        if(balFactor>1 && val<node.left.data)
        {
            //left left case
            return rightRotate(node);
        }
        if(balFactor>1 && val>node.left.data)
        {
            //left right case
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(balFactor<-1 && val>node.right.data)
        {
            //right right case
            return leftRotate(node);
        }
        if(balFactor<-1 && val<node.right.data)
        {
            //right left case
             node.right=rightRotate(node.right);
             return leftRotate(node);
        }
        return node;
    }

    private int getBalanceFactor(Node node)
    {
        if(node==null)
        return 0;
        return (getHeight(node.left)-getHeight(node.right));
    }

    private Node rightRotate(Node z)
    {
        Node y=z.left;
        Node t3=y.right;

        y.right=z;
        z.left=t3;

        z.height=1+max(getHeight(z.left),getHeight(z.right));
        y.height=1+max(getHeight(y.left),getHeight(y.right));

        return y;
    }

    private Node leftRotate(Node z)
    {
        Node y=z.right;
        Node t3=y.left;

        y.left=z;
        z.right=t3;

        z.height=1+max(getHeight(z.left),getHeight(z.right));
        y.height=1+max(getHeight(y.left),getHeight(y.right));

        return y;
    }

    public void inOrder(Node node)
    {
        if(node!=null)
        {
            inOrder(node.left);
            System.out.println(node.data+" height is "+node.height);
            inOrder(node.right);
        }
    }

    public int getHeight(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        return node.height;
    }

    public int max(int a,int b)
    {
        return a>b?a:b;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
       AVL tree=new AVL(50);
       tree.getData(20);
       tree.getData(60);
       tree.getData(10);
       tree.getData(30);
       tree.getData(40);
       tree.inOrder(tree.node);
    }
}

