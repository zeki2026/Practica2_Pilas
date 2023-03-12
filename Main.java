
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
        int res;

        System.out.print("Escribe una expresion separada por espacios: ");
        expresion = scan.nextLine();

        Postfijo postfijo = new Postfijo(pila,expresion);

        resultado = postfijo.balanceo();
        
        if(resultado==false){
            System.out.println("La expresion no esta correctamente balanceada: ");
        }else{
            System.out.println("La expresion esta correctamente balanceada: ");
            System.out.print("Notacion Postfija: ");
            postfijo.imprimir_postfijo();
            res = postfijo.evaluacion_postfijo();
            System.out.println("\nEvaluacion Postfija: " + res);
        }
        

        scan.close();
        
    }
}