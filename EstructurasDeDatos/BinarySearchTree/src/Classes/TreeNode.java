package Classes;

public class TreeNode{
   
    private int valor;
    private TreeNode nodoIzq;
    private TreeNode nodoDer;

    public TreeNode(int valor) {
        this.valor = valor;
        nodoIzq = null;
        nodoDer = null;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public TreeNode getNodoIzq() {
        return nodoIzq;
    }

    public TreeNode getNodoDer() {
        return nodoDer;
    }
    
    public void insertar(int valor_ingresado){
        
        if(valor_ingresado < valor){
            //Inserta en el lado izquierdo
            if(nodoIzq == null){
                nodoIzq = new TreeNode(valor_ingresado);
            }else{
                nodoIzq.insertar(valor_ingresado);
            }
            
        }else{
            //Insertar en el lado derecho
            if(nodoDer == null){
                nodoDer = new TreeNode(valor_ingresado);
            }else{
                nodoDer.insertar(valor_ingresado);
            }
        }
    }
    
}
