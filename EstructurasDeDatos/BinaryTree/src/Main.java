import Class.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hola mundo");

        //Nodos
        BinaryNode nodo1 = new BinaryNode(1);
        BinaryNode nodo2 = new BinaryNode(2);
        BinaryNode nodo3 = new BinaryNode(3);
        BinaryNode nodo4 = new BinaryNode(4);
        BinaryNode nodo5 = new BinaryNode(5);
        BinaryNode nodo6 = new BinaryNode(6);
        BinaryNode nodo7 = new BinaryNode(7);
        BinaryNode nodo8 = new BinaryNode(8);
        BinaryNode nodo9 = new BinaryNode(9);

        nodo1.setLeft(nodo2);
        nodo1.setRight(nodo3);
        nodo2.setLeft(nodo4);
        nodo2.setRight(nodo5);
        nodo3.setLeft(nodo6);
        nodo3.setRight(nodo7);
        BinaryTree arbol = new BinaryTree<Object>(nodo1);

        System.out.println("Pre-order:\n");
        arbol.preorder(arbol.getRoot());
        System.out.println("Post-order:\n");
        arbol.postorder(arbol.getRoot());
        System.out.println("In-order:\n");
        arbol.inorder(arbol.getRoot());
        System.out.println();
    }
}
