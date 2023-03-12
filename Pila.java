public class Pila{
    Nodo head;//puntero del head
    int tamanio;

    /**
     * Constructor por defecto
     */
    public Pila(){
        head = null;
        tamanio = 0;
    }

    /**
     * Insertar int a la cola
     * @param val
     */
    void pushi(int val){
        Nodo nodo = new Nodo(val);

        nodo.setval(val);//valor del nodo
        nodo.setnext(head);//apuntar a la cabeza de la pila
        
        head = nodo;
        tamanio++;
    }

    /**
     * Insertar string a la cola
     * @param operador
     */
    void pushs(String operador){
        Nodo nodo = new Nodo(operador);

        nodo.setoperador(operador);//valor del nodo
        nodo.setnext(head);//apuntar a la cabeza de la pila
        
        head = nodo;
        tamanio++;
    }

    /**
     * Quitar valor entero de la lista
     * @return valor de la lista
     */
    int popi(){
        int valor;
        valor = head.getval();
        head = head.getnodo();

        tamanio--;
        return valor;
    }

    /**
     * Quitar valor string de la lista
     * @return valor de la lista
     */
    String pops(){
        String op;
        op = head.getoperador();
        head = head.getnodo();

        tamanio--;
        return op;
    }

    /**
     * 
     * @return primer valor de la cola
     */
    String top(){
        return head.getoperador();
    }

    /**
     * 
     * @return primer valor de la cola
     */
    int topi(){
        return head.getval();
    }

    /**
     * geter
     * @return tamaño de la cola
     */
    int gettamanio(){
        return tamanio;
    }
}
