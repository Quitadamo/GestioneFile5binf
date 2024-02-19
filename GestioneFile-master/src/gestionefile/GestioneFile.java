package gestionefile;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Matrice m = new Matrice("VIGENERE");
    Vigenere v = new Vigenere(0, 12, 0, 12, m);
    Vigenere v1 = new Vigenere(12, 26, 0, 12, m);
    Vigenere v2 = new Vigenere(0, 12, 0, 12, m);
    Vigenere v3 = new Vigenere(12, 26, 12, 26, m);
    Thread t = new Thread(v);
    Thread t1 = new Thread(v1);
    Thread t2 = new Thread(v2);
    Thread t3 = new Thread(v3);
    t.start();
    t1.start();
    t2.start();
    t3.start();
    try {
      t.join();
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException ex) {

    }
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci username:");
        String username = input.nextLine();
        String usernameC=m.cifra(username);
        System.out.println("Enter password:");
        String password = input.nextLine();
        String passwordC= m.cifra(password);
        Scrittore Copia = new Scrittore("user.json", usernameC, passwordC);
        Scrittore usercsv = new Scrittore("user.csv", usernameC,passwordC);
        Scrittore copiacsv = new Scrittore("copia.csv", usernameC,passwordC);
        //3) SCRITTURA
       
        Thread threadScrittore = new Thread(Copia);
        Thread threaduser= new Thread(usercsv);
        Thread threadCopia= new Thread(copiacsv);
        threadScrittore.start();
        threaduser.start();
        threadCopia.start();
    }
    
}
