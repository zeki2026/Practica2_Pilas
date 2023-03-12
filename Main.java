
import java.util.Scanner;

/**
 * Main
 */
public class Main {


    public static void main(String[] args) {
        Pila pila = new Pila();
        String expresion;
        Scanner scan = new Scanner(System.in);
        boolean resultado;
        int res, res2;

        System.out.print("Escribe una expresion separada por espacios: ");
        expresion = scan.nextLine();

        Postfijo postfijo = new Postfijo(pila,expresion);
        Prefijo prefijo = new Prefijo(pila,expresion);

        resultado = postfijo.balanceo();
        
        if(resultado==false){
            System.out.println("La expresion no esta correctamente balanceada: ");
        }else{
            System.out.println("La expresion esta correctamente balanceada: ");

            System.out.print("\nNotacion Prefija: ");
            prefijo.imprimir_prefijo();

            System.out.print("\notacion Postfija: ");
            postfijo.imprimir_postfijo();

            
            res2 = prefijo.evaluacion_prefijo();
            System.out.println("\nEvaluacion Postfija: " + res2);

            res = postfijo.evaluacion_postfijo();
            System.out.println("Evaluacion Postfija: " + res);
        }
        

        scan.close();
        
    }
}