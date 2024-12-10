package GMS;

class Node
{
    int id; // story event id
    String desc; // event description
    int height;
    int balfac;
    Node left,right;
    Node()
    {
        id=height=balfac=0;
        desc="";
        left=right=null;
    }
    Node(int id,String desc)
    {
        this.id=id;
        this.desc=desc;
    }
}
public class Storyline 
{
    static Node root=null;
    static boolean flag=false;
    
    void updateHeight(Node n)
    {
        n.height=1+Math.max(height(n.left),height(n.right));
    }
    
    void updateBal(Node n)
    {
        n.balfac=height(n.left)-height(n.right);
    }
    
    int height(Node n)
    {
        if(n==null)
        {
            return -1;
        }
        else
            return n.height;
    }
    
    Node insert(int id,String desc,Node node)
    {
        if(node==null)
        {
            return new Node(id, desc);
        }
        else if(id>node.id)
        {
            node.right=insert(id, desc,node.right);
            node=rebalance(node);
        }
        else if(id<node.id)
        {
            node.left= insert(id,desc,node.left);
            node= rebalance(node);
        }
        else
        {
            throw new RuntimeException("Stories with same ids can't be inserted");
        }
        return node;
    }
    
    Node rebalance(Node z)
    {
        updateHeight(z);
        updateBal(z);
        int bal=z.balfac;
        if(bal==0||bal==1||bal==-1)
            return z;
        else
        {
            if(bal>1)
            {
                if(height(z.left.left)>height(z.left.right))
                    z=RR(z);
                else
                {
                    z.left=LL(z.left);
                    z=LL(z);
                }
            }
            if(bal<-1) 
            {
                if(height(z.right.right)>height(z.right.left))
                    z=LL(z);
                else
                {
                    z.right=LL(z.right);
                    z=RR(z);
                }
            }
        }
        return z;
    }
    
    Node LL(Node y)
    {
        Node x=y.right;
        Node z=x.left;
        x.left=y;
        y.right=z;
        updateHeight(y);
        updateHeight(x);
        updateBal(y);
        updateBal(x);
        return x;
    }
    
    Node RR(Node y)
    {
        Node x=y.left;
        Node z=x.right;
        x.right=y;
        y.left=z;
        updateHeight(y);
        updateHeight(x);
        updateBal(y);
        updateBal(x);
        return x;
    }
    
    void inorder(Node root)
    {
        Node temp=root;
        if(temp!=null)
        {
            inorder(temp.left);
            System.out.println("( "+temp.id+", "+temp.desc+", "+temp.height+", "+temp.balfac+" )");
            inorder(temp.right);
        }
    }
    
    public Node search(int key) 
    {
        return searchRec(root, key);
    }

    private Node searchRec(Node node, int key) 
    {
        if (node == null)
            return null;

        if (key == node.id)
            return node;
        else if (key < node.id)
            return searchRec(node.left, key);
        else
            return searchRec(node.right, key);
    }
}
