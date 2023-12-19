import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class maquinaSnacks {
    static final int demanarSnack = 1;
    static final int mostrarSnack = 2;
    static final int omplirSnacks = 3;
    static final int apagarSnacks = 4;
    public static void main(String[] args) {
        boolean maquinaEncesa = true;
        Scanner teclat = new Scanner(System.in);
        

        String[][] nomSnack = {
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
            };
            
            double[][] preu = {
            {1.1, 0.8, 1.5, 0.9},
            {1.8, 1, 1.2, 1},
            {1.8, 1.3, 1.2, 0.8},
            {1.5, 1.1, 1.1, 1.1}
            };

        while (maquinaEncesa) {
            System.out.println("\t0\t\t1\t\t\t2\t\t3");
            System.out.println("\n");
            for (int i = 0; i < nomSnack.length; i++) {
                for (int j = 0; j < nomSnack[i].length; j++) {
                    if (j == 0)System.out.print(i+"\t");
                    System.out.print("|"+nomSnack[i][j]+"|\t");
                    if (nomSnack[i][j].length()<6)System.out.print("\t\t");
                    if (nomSnack[i][j].length() ==6 && i != 0)System.out.print("\t");
                }
                System.out.println("\n");
            }
            int opcio = teclat.nextInt();
            switch (opcio) {
                case demanarSnack:

                    break;
                case mostrarSnack:

                    break;
                case omplirSnacks:

                    break;
                case apagarSnacks:
                    maquinaEncesa = false;
                    break;
                default:
                    System.out.println("Opció incorrecta");
                    break;
        }
        }
    }
}