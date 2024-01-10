import java.util.Scanner;

public class maquinaSnacks {
    static final int DEMANARSNACK = 1;
    static final int MOSTRARSNACK = 2;
    static final int OMPLIRSNACKS = 3;
    static final int APAGARSNACKS = 4;

    static int[][] quantitatSnack={
        {5,5,5,5},{5,5,5,5},{5,5,5,5},{5,5,5,5}
    };
    static String[][] nomSnack = {
    {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
    {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
    {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
    {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
    };

    static double[][] preu = {
    {1.1, 0.8, 1.5, 0.9},
    {1.8, 1, 1.2, 1},
    {1.8, 1.3, 1.2, 0.8},
    {1.5, 1.1, 1.1, 1.1}
    };

    static double preuTotal;
    
    static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {

        boolean maquinaEncesa = true;
        
        while (maquinaEncesa) {
           
            System.out.println("\n\tSelecciona una Opció: \n\n\t\t1)Demanar Snack\n\n\t\t2)Mostrar Snack"+
            "\n\n\t\t3)Omplir Snacks\n\n\t\t4)Apagar Snacks");
            int opcio = teclat.nextInt();
            switch (opcio) {
                
                case DEMANARSNACK:
                    mostrarMaquina();
                    seleccionarSnack();
                    break;
                case MOSTRARSNACK:
                    mostrarProductes();
                    break;
                case OMPLIRSNACKS:
                    omplirMaquina();
                    break;
                case APAGARSNACKS:
                    maquinaEncesa = false;
                    System.out.println("Total recaudat: "+ preuTotal);
                    break;
                default:
                    System.out.println("Opció incorrecta");
                    break;
        }
        }
    }
    static void mostrarMaquina(){
            System.out.println("\n");
            for (int i = 0; i < nomSnack.length; i++) {
                for (int j = 0; j < nomSnack[i].length; j++) {
                    System.out.print("|"+nomSnack[i][j]+"|\t");
                    if (nomSnack[i][j].length()<6)System.out.print("\t\t");
                    if (nomSnack[i][j].length() ==6 && i != 0)System.out.print("\t");
                }
                System.out.println("\n");
            }
    }
    static void mostrarProductes(){
        for (int i = 0; i < nomSnack.length; i++){
            for (int j = 0; j <nomSnack[i].length; j++){
                System.out.println("Codi:"+(i)+(j)+" "+nomSnack[i][j]+" "+ preu[i][j]);
            }
            
        }
    }
    static void seleccionarSnack(){
        boolean valid = false;
        String seleccio;
        int eix_X = 0;
        int eix_Y = 0;
        String error = "ERROR: la coordenada no es valida, torna a provar";

        while (!valid) {
             seleccio = teclat.next();
            if (seleccio.length()==2){
                try{
                    eix_Y = seleccio.charAt(0) -48;
                    eix_X = seleccio.charAt(1) -48;
                    if (eix_X >=0 && eix_X <=3 && eix_Y >=0 && eix_Y <= 3) valid = true;
                    else System.out.println(error);
                }catch(Exception e){
                    teclat.next();
                    System.out.println(error);
                }
            }else{
                valid = false;
                System.out.println(error);
            } 
        }
        do {
           

        }while (!valid);

        preuTotal+=preu[eix_Y][eix_X];
        if (quantitatSnack[eix_Y][eix_X] > 0) --quantitatSnack[eix_Y][eix_X];
        else{
            System.out.println("\n\tNo queda "+ nomSnack[eix_Y][eix_X]);
            return;
        }
        
    }
    static void omplirMaquina(){
        String contrasenya = "MaquinetaDAW";
        String inputUsuari = teclat.next();
        boolean valid = false;
        String seleccio;
        int eix_X = 0;
        int eix_Y = 0;
        int quantitat = 0;
        String error = "ERROR: la coordenada no es valida, torna a provar";

        if (contrasenya.equals(inputUsuari)){

            System.out.println("Introdueix el codi del producte");

            while (!valid) {
                seleccio = teclat.next();
                if (seleccio.length()==2){
                    try{
                        eix_Y = seleccio.charAt(0) -48;
                        eix_X = seleccio.charAt(1) -48;
                        if (eix_X >=0 && eix_X <=3 && eix_Y >=0 && eix_Y <= 3) valid = true;
                        else System.out.println(error);
                    }catch(Exception e){
                        teclat.next();
                        System.out.println(error);
                    }
                }else{
                    valid = false;
                    System.out.println(error);
                } 
            }
            valid = false;
            System.out.println("introdueix la quantitat");
            while (!valid) {
                try{
                    quantitat = teclat.nextInt();
                    valid = true;
                }catch(Exception e){
                    teclat.next();
                    System.out.println("No has introduit un nombre valid");
                }
            }
            quantitatSnack[eix_Y][eix_X] = quantitat;
            System.out.println("La quantitat actual de "+ nomSnack[eix_Y][eix_X]+ "es: "+ quantitatSnack[eix_Y][eix_X]);
        }
    }
}