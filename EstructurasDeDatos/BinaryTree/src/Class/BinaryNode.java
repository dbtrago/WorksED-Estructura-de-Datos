package Class;

public class BinaryNode <T>
{
    private BinaryNode left,right;    

    private T object;

    //Constructor
    public BinaryNode()
    {
        this.object =  null;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(T object)
    {
        this.object =  object;
        this.left = null;
        this.right = null;
    }
    public BinaryNode(T object, BinaryNode left, BinaryNode right)
    {
        this.object =  object;
        this.left = left;
        this.right = right;
    }
    //Getters and setters
    public BinaryNode getLeft()
    {
        return left;
    }

    public void setLeft(BinaryNode left)
    {
        this.left = left;
    }

    public BinaryNode getRight()
    {
        return right;
    }

    public void setRight(BinaryNode right)
    {
        this.right = right;
    }



    public T getObject() {
        return object;
    }

    public void setObject(T object)
    {
        this.object = object;
    }
}
