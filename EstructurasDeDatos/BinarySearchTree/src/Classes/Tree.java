package Classes;

public class Tree {
    
    TreeNode raiz;

    public Tree() {
        this.raiz = null;
    }
    
    public void insertar(int valor){
        
        if(raiz == null){
            raiz = new TreeNode(valor);
        }else{
            raiz.insertar(valor);
        }
    }
    
    //Método preorden
    public void llamarPreOrden(){
        preOrder(raiz);
    }
    
    public void preOrder(TreeNode nodo){
        
        if(nodo == null){
            return;
        }else{
            System.out.println(nodo.getValor());
            preOrder(nodo.getNodoIzq());
            preOrder(nodo.getNodoDer());
        }
    }
    
    //Método inorden
    public void llamarInOrder(){
        inOrder(raiz);
    }
    
    public void inOrder(TreeNode nodo){
        
        if(nodo == null){
            return;
        }else{
            inOrder(nodo.getNodoIzq());
            System.out.println(nodo.getValor());
            inOrder(nodo.getNodoDer());
        }
    }
    
    //Método posorden
    public void llamarPosOrder(){
        posOrder(raiz);
    }
    
    public void posOrder(TreeNode nodo){
        
        if(nodo == null){
            return;
        }else{
            posOrder(nodo.getNodoIzq());
            posOrder(nodo.getNodoDer());
            System.out.println(nodo.getValor());
        }
    }
  
}
