package iksoks;

import java.util.Scanner;

public class XO {

	

    public static void main(String[] args) {

    	Scanner s = new Scanner(System.in);
		char[][] matrica = new char[3][3];
        boolean pobednik = false;
        boolean kraj =false;
        char iks = 'X';
        char oks = 'O';

        //punjene matrice
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matrica[i][j] = '*';
            }
        }
        System.out.println("Dobro dosli u igru XO!");
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println("");
        }
        
        do {
            //Igrac X
            //Unesi red i kolonu na koju zelis da odgiras
            System.out.println("Na potezu je igrac X!");
            System.out.println("Unesi red:");
            int red = s.nextInt();

            //Provera da li je unos validan 01 10 56
            while (red > 2 || red < 0){
                System.out.println("Uneli ste broj: " + red + " koji je pogresan broj, unesite ponovo: ");
                red = s.nextInt();
            }
            //Unos kolone
            System.out.println("Unesi kolonu:");
            int kolona = s.nextInt();
            //Provera da li je unos validan 01 10 56
            while (kolona > 2 || kolona < 0 ){
                System.out.println("Uneli ste broj: " + red + " koji je pogresan broj, unesite ponovo: ");
                kolona = s.nextInt();
            }
            //Provera da li je polje popunjeno
            while (matrica[red][kolona] != '*'){
                System.out.println("Polje [" + red + "," + kolona + "] je popunjeno, unesite ponovo: ");
                System.out.println("Novi red: ");
                red = s.nextInt();
                System.out.println("Nova kolona: ");
                kolona = s.nextInt();
            }
            matrica[red][kolona] = iks;

            //ispis matrice posle unosa
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(matrica[i][j] + " ");
                }
                System.out.println("");
            }
            //Provera da li je pobednik X
            if ((matrica[0][0] == 'X' && matrica[1][0] == 'X' && matrica[2][0] == 'X') || (matrica[0][1] == 'X' && matrica[1][1] == 'X' && matrica[2][1] == 'X')
                    || (matrica[0][2] == 'X' && matrica[1][2] == 'X' && matrica[2][2] == 'X') || (matrica[0][0] == 'X' && matrica[0][1] == 'X' && matrica[0][2] == 'X')
                    || (matrica[1][0] == 'X' && matrica[1][1] == 'X' && matrica[1][2] == 'X') || (matrica[2][0] == 'X' && matrica[2][1] == 'X' && matrica[2][2] == 'X')
                    || (matrica[0][0] == 'X' && matrica[1][1] == 'X' && matrica[2][2] == 'X') || (matrica[0][2] == 'X' && matrica[1][1] == 'X' && matrica[2][0] == 'X')) {
                System.out.println("Pobednik je igrac X");
                pobednik = true;

                //Ako je igra zavrsena restartuj matricu i pokreni novu igru (1) da (2) ne
                System.out.println("Igra je zavrsena! Da li zelite novu igru? DA-1 | NE-2");
                int opcija = s.nextInt();
                while (opcija < 1 || opcija > 2) {
                    System.out.println("Uneli ste pogresan broj, unesite ponovo:");
                    opcija = s.nextInt();
                }
                //ako je 1 restart matrice matrica = new car [][]; i popunis zvezdicama, continue
                if (opcija == 1) {
                    System.out.println("Matrica restartovana!");
                    matrica = new char[3][3];
                    //punjene matrice
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){
                            matrica[i][j] = '*';
                        }
                    }
                    continue;
                }
                //Ako je opcija 2 onda igra je zavrsena kraj == true, pobednik == true break;
                else {
                    System.out.println("Igra je zavrsena!");
                    kraj = true;
                    pobednik = true;
                    break;
                }
            }
            //provera da li je nereseno
            if(nereseno(matrica)){
                System.out.println("NERESENO!");

                pobednik = true;

                //Ako je igra zavrsena restartuj matricu i pokreni novu igru (1) da (2) ne
                System.out.println("Igra je zavrsena! Da li zelite novu igru? DA-1 | NE-2");
                int opcija = s.nextInt();
                while (opcija < 1 || opcija > 2) {
                    System.out.println("Uneli ste pogresan broj, unesite ponovo:");
                    opcija = s.nextInt();
                }
                //ako je 1 restart matrice matrica = new car [][]; i popunis zvezdicama, continue
                if (opcija == 1) {
                    System.out.println("Matrica restartovana!");
                    matrica = new char[3][3];
                    //punjene matrice
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){
                            matrica[i][j] = '*';
                        }
                    }
                    continue;
                }
                //Ako je opcija 2 onda igra je zavrsena kraj == true, pobednik == true break;
                else {
                    System.out.println("Igra je zavrsena!");
                    kraj = true;
                    pobednik = true;
                    break;
                }
            }
            //Igrac O
            //Unesi red i kolonu na koju zelis da odgiras
            System.out.println("Na potezu je igrac O! ");
            System.out.println("Unesi red:");
            red = s.nextInt();

            //Provera da li je unos validan 01 10 56
            while (red > 2 || red < 0){
                System.out.println("Uneli ste broj: " + red + " koji je pogresan broj, unesite ponovo: ");
                red = s.nextInt();
            }
            //Unos kolone
            System.out.println("Unesi kolonu:");
            kolona = s.nextInt();
            //Provera da li je unos validan 01 10 56
            while (kolona > 2 || kolona < 0 ){
                System.out.println("Uneli ste broj: " + red + " koji je pogresan broj, unesite ponovo: ");
                kolona = s.nextInt();
            }
            //Provera da li je polje popunjeno
            while (matrica[red][kolona] != '*'){
                System.out.println("Polje [" + red + "," + kolona + "] je popunjeno, unesite ponovo: ");
                System.out.println("Novi red: ");
                red = s.nextInt();
                System.out.println("Nova kolona: ");
                kolona = s.nextInt();
            }
            matrica[red][kolona] = oks;

            //ispis matrice posle unosa
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(matrica[i][j] + " ");
                }
                System.out.println("");
            }
            //Provera da li je pobednik O
            if ((matrica[0][0] == 'O' && matrica[1][0] == 'O' && matrica[2][0] == 'O') || (matrica[0][1] == 'O' && matrica[1][1] == 'O' && matrica[2][1] == 'O')
                    || (matrica[0][2] == 'O' && matrica[1][2] == 'O' && matrica[2][2] == 'O') || (matrica[0][0] == 'O' && matrica[0][1] == 'O' && matrica[0][2] == 'O')
                    || (matrica[1][0] == 'O' && matrica[1][1] == 'O' && matrica[1][2] == 'O') || (matrica[2][0] == 'O' && matrica[2][1] == 'O' && matrica[2][2] == 'O')
                    || (matrica[0][0] == 'O' && matrica[1][1] == 'O' && matrica[2][2] == 'O') || (matrica[0][2] == 'O' && matrica[1][1] == 'O' && matrica[2][0] == 'O')) {
                System.out.println("Pobednik je igrac O");

                pobednik = true;

                //Ako je igra zavrsena restartuj matricu i pokreni novu igru (1) da (2) ne
                System.out.println("Igra je zavrsena! Da li zelite novu igru? DA-1 | NE-2");
                int opcija = s.nextInt();
                while (opcija < 1 || opcija > 2) {
                    System.out.println("Uneli ste pogresan broj, unesite ponovo:");
                    opcija = s.nextInt();
                }
                //ako je 1 restart matrice matrica = new car [][]; i popunis zvezdicama, continue
                if (opcija == 1) {
                    System.out.println("Matrica restartovana!");
                    matrica = new char[3][3];
                    //punjene matrice
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){
                            matrica[i][j] = '*';
                        }
                    }
                    continue;
                }
                //Ako je opcija 2 onda igra je zavrsena kraj == true, pobednik == true break;
                else {
                    System.out.println("Igra je zavrsena!");
                    kraj = true;
                    pobednik = true;
                    break;
                }
            }


        }while(pobednik == false || kraj == false);

        System.out.println("Hvala Vam sto ste igrali nasu igru.");


    }

    public static boolean nereseno(char[][] matrica){

        int count = 0;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(matrica[i][j] != '*'){
                    count++;
                }
            }
        }
        return (count == 9);
    }


}

