import java.util.Scanner;

public class Regla {

    public static void dibujarRegla(int tamanioRegla, int longitudMayor) {
        dibujarLinea(longitudMayor, 0, 0, 0);
        int multiplo = 1;
        int entero = 0;
        for (int j = 1; j <= tamanioRegla; j++) {
            dibujarIntervalo(longitudMayor - 1, multiplo, entero);
            //entero++;
            dibujarLinea(longitudMayor, j, multiplo, entero);
        }
    }

    private static void dibujarIntervalo(int longitudCetral, int multiplo, int entero) {
        //System.out.println("multiplo " + multiplo);
        //int temp = 0;
        if (longitudCetral >= 1) { 
            multiplo = multiplo * 2;
            dibujarIntervalo(longitudCetral - 1, multiplo, entero);
            entero++;
            dibujarLinea(longitudCetral, multiplo, entero);
            entero++;
            dibujarIntervalo(longitudCetral - 1, multiplo, entero);
        }
    }

    private static void dibujarLinea(int numLineas, int etiqueta, int multiplo, int entero) {
        //int entero = 0;
        for (int j = 0; j < numLineas; j++)
            System.out.print("-");
        if (etiqueta >= 0)
            System.out.print("\t" + etiqueta);
        if (etiqueta == -1){
            //entero++;
            System.out.print(" " + entero + "/" + multiplo);
        }
        System.out.print("\n");
    }

    private static void dibujarLinea(int numLineas, int multiplo, int entero) {
        //entero++;
        dibujarLinea(numLineas, -1, multiplo, entero);
    }

    public static void main(String[] args) {
        System.out.println("***************************");
        System.out.println("***\tDibujar regla\t***");
        System.out.println("***************************");

        System.out.println("\nIngrese el tamanio de la regla: ");
        Scanner sc = new Scanner(System.in);
        int tamanioRegla = sc.nextInt();
        
        System.out.println("Ingrese longitud mayor de las lineas: ");
        int longitudMayor = sc.nextInt();
        dibujarRegla(tamanioRegla, longitudMayor);
    }
}