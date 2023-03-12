public final class Nodo {
    private int val;
    private Nodo next;
    private String operador;

    public Nodo(int val){
        this.val = val;
        next = null;
    }

    public Nodo(String operador){
        this.operador = operador;
        next = null;
    }

    public Nodo(int val, Nodo next){
        this.val = val;
        this.next = null;
    }

    void setval(int val){
        this.val = val;
    }

    int getval(){
        return val;
    }

    void setnext(Nodo next){
        this.next = next;
    }

    Nodo getnodo(){
        return next;
    }

    void setoperador(String operador){
        this.operador = operador;
    }

    String getoperador(){
        return operador;
    }
}
