package Class;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T>
{
    private BinaryNode root;
    //Constructor
    public BinaryTree()
    {
        this.root = null;
    }
    public BinaryTree(BinaryNode root)
    {
        this.root = root;
    }
    //Metodos
    public void preorder(BinaryNode root)
    {
        if(root != null)
        {
            System.out.println(root.getObject());
            //Primero la izquierda
            BinaryNode left = root.getLeft();

            //Primero la derecha
            BinaryNode right = root.getRight();
            Anchura(left);
            Anchura(right);
        }
    }

    public void Anchura(BinaryNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryNode node = queue.remove();
            System.out.println(node.getObject());

            BinaryNode left = node.getLeft();
            if (left != null)
            {
                queue.add(left);
            }
            BinaryNode right = node.getRight();
            if (right != null)
            {
                queue.add(right);
            }
        }
    }

    public void postorder(BinaryNode root)
    {
        if (root != null)
        {
            BinaryNode left = root.getLeft();
            BinaryNode right = root.getRight();
            postorder(left);
            postorder(right);
            System.out.println(root.getObject());
        }
    }

    public void inorder(BinaryNode root)
    {
        if (root != null) {
            BinaryNode left = root.getLeft();
            BinaryNode right = root.getRight();
            inorder(left);
            System.out.println(root.getObject());
            inorder(right);
        }
    }


    //Getters and setters

    public BinaryNode getRoot()
    {
        return root;
    }

    public void setRoot(BinaryNode root)
    {
        this.root = root;
    }
}
