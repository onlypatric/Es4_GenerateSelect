import java.util.Scanner;

import pkg.util.RUtil;
/**
 * App
 */
public class App {

    public static void main(String[] args) {

        RUtil r = new RUtil();
        Scanner sc = new Scanner(System.in);
        int voto = r.randInt(1, 10),select=2;
        do {
            try {
                System.out.print("Inserire un numero\n0 - stampa \"*\" in orizzontale\n1 - stampa \"#\" in verticale\nSeleziona: ");
                // si usa parseInt (se si mette solo sc.nextInt potrà funzionare, ma se da "Exception" Scanner si "autochiude" e non funziona più)
                select=Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Errore durante l'inserimento, probabilmente il numero inserito è in un formato incorretto");
            }
        } while (select<0||select>1);
        String selectionString;
        if(select==0){
            selectionString="*";
        }else{
            selectionString="#\n";
        }
        System.out.println(selectionString.repeat(voto));
    }
}