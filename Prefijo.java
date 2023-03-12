public class Prefijo extends Postfijo{
    private String[] prefijo;

    public Prefijo (Pila pila,String expresion){
        super(pila, expresion);
        
        prefijo = new String[super.expresion.length];
    }

    public void imprimir_prefijo(){
        int i, cont;
        i = expresion.length - 1;
        cont = prefijo.length - 1;

        while(i >= 0 ){
            if(Character.isDigit(expresion[i].charAt(0))){//si es un numero
                prefijo[cont] = expresion[i];//guardar en postfijo el numero
                cont--;
            }
            if(operadores(i) != 0){//si es un operador
                while( pila.gettamanio() != 0){//mientras la pila no este vacia
                    if((operador_top() != 3) && (operadores(i) <= operador_top()) ){//el top de la pila no sea ")" y el operador actual sea <= al top de la pila
                    prefijo[cont] = pila.pops();
                    cont--;
                    }else break;
                }
                if(operadores(i) <= 3){//si es un operador que no sea "("
                    pila.pushs(expresion[i]);//guardar el operador
                }
                if(operadores(i) == 4){//Si el operador actual es "(" 
                    while(operador_top() != 3){//mientras el top de la pila sea diferente de ")"
                        prefijo[cont] = pila.pops();//guardar el top en el prefijo
                        cont--;
                    }
                    pila.pops();//sacar el operador ")" de la pila
                }

                
            }
            i--;
        }
        while(pila.gettamanio() != 0){
            prefijo[cont] = pila.pops();//agregar operador 
            cont--;
        }

        System.out.print("[");
        for(int j = 0; j < prefijo.length; j++){
            if(prefijo[j] != null){
                System.out.print(", " + prefijo[j] );
            }
        }
        System.out.print("]");
    }

    public int evaluacion_prefijo(){
        int i, op1, op2, conv, res;
        i = prefijo.length-1;
        while(prefijo[i] != null){
            if(Character.isDigit(prefijo[i].charAt(0))){
                conv = Integer.parseInt(prefijo[i]);//convertir a int
                pila.pushi(conv);
            }else{
                op1 = pila.popi();
                op2 = pila.popi();
                res = evaluar(op1, i , op2);
                pila.pushi(res);
            }
            i--;
        }

        return pila.popi();
    }

    private int evaluar(int op1,int i, int op2){
        if(prefijo[i].equals("+")){
            return (op1 + op2);
        }if(prefijo[i].equals("*")){
            return (op1 * op2);
        }if(prefijo[i].equals("-")){
            return (op1 - op2);
        }if(prefijo[i].equals("/")){
            return (op1 / op2);
        }
        return 0;
    }


    
}
