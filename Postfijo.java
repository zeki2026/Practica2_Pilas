public class Postfijo {
    protected String[] expresion;
    protected Pila pila;
    private String[] postfijo;

    public Postfijo(Pila pila, String expresion){
        this.expresion = expresion.split(" ");
        postfijo = new String[this.expresion.length];
        this.pila = pila;
    }

    /**
     * Balanceo de parentesis
     * @return true si esta correctamente balanceado, false lo contrario
     */
    public boolean balanceo(){
        int cont1 = 0, cont2 = 0;

        for(int i = 0; i < expresion.length; i++){
            if(expresion[i].equals("(")){
                cont1++;
            }
            if(expresion[i].equals(")")){
                cont2++;
            }
        }
        if(cont1 != cont2){
            return false;
        }
        return true;
    }

    /**
     * Convertir sufijo a postfijo 
     */
    public void imprimir_postfijo(){
        int i = 0, cont = 0;


        System.out.print("[");

        while( i < expresion.length ){
            if(Character.isDigit(expresion[i].charAt(0))){//si es un numero
                postfijo[cont] = expresion[i];//guardar en postfijo el numero

                System.out.print(", " + postfijo[cont] );
                cont++;
                //val = Integer.parseInt(postfijo[i]);
            }

            if(operadores(i) != 0){//si es un operador
                if(expresion[i].equals(")")){// si es el operador de cierre
                    while(operador_top() != 4 ){//mientras no sea el operador de apertura
                        postfijo[cont] = pila.pops();//agregar operador
                        System.out.print(", " + postfijo[cont] );
                        cont++;
                    }
                    pila.pops();
                }

                while(pila.gettamanio() != 0){//mientras la pila no este vacia
                    if((operadores(i) <= operador_top()) && (operador_top() != 4)){//si el operador actual <= prioridad de la pila y mientras no sea el operador de apertura
                        postfijo[cont] = pila.pops();//agregar operador 
                        System.out.print(", " + postfijo[cont] );
                        cont++;
                    }else break;
                }

                if(operadores(i) != 3){//si el operador es diferente al operador de cierre
                    pila.pushs(expresion[i]);//agregar operador a la pila
                }
                
            }
            i ++;
        }
        while(pila.gettamanio() != 0){
            postfijo[cont] = pila.pops();//agregar operador 
            System.out.print(", " + postfijo[cont] );
            cont++;
        }
        System.out.print("]");
    }

    public int operadores(int i){
        if(expresion[i].equals("+") || expresion[i].equals("-")){
            return 1;
        }if(expresion[i].equals("*") || expresion[i].equals("/")){
            return 2;
        }if(expresion[i].equals(")")){
            return 3;
        }if(expresion[i].equals("(")){
            return 4;
        }
        return 0;
    }

    public int operador_top(){
        if(pila.top().equals("+") || pila.top().equals("-")){
            return 1;
        }if(pila.top().equals("*") || pila.top().equals("/")){
            return 2;
        }if(pila.top().equals(")")){
            return 3;
        }if(pila.top().equals("(")){
            return 4;
        }
        return 0;
    }

    public int evaluacion_postfijo(){
        int i = 0, op1, op2, conv, res;
        while(postfijo[i] != null){
            if(Character.isDigit(postfijo[i].charAt(0))){
                conv = Integer.parseInt(postfijo[i]);//convertir a int
                pila.pushi(conv);
            }else{
                op2 = pila.popi();
                op1 = pila.popi();
                res = evaluar(op1, i , op2);
                pila.pushi(res);
            }
            i++;
        }

        return pila.popi();
    }

    private int evaluar(int op1,int i, int op2){
        if(postfijo[i].equals("+")){
            return (op1 + op2);
        }if(postfijo[i].equals("*")){
            return (op1 * op2);
        }if(postfijo[i].equals("-")){
            return (op1 - op2);
        }if(postfijo[i].equals("/")){
            return (op1 / op2);
        }
        return 0;
    }

    public String[] getpostfijo(){
        return postfijo;
    }

    public String[] getexpresion(){
        return expresion;
    }

}
