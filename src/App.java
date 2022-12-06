import java.util.Scanner;

import pkg.util.RUtil;
/**
 * App
 */
public class App {

    public static void main(String[] args) {

        RUtil r = new RUtil();
        Scanner sc = new Scanner(System.in);
        int voto0 = r.randInt(1, 10),select=2;
        int voto1 = r.randInt(1, 10);
        do {
            try {
                System.out.print("Inserire un numero\n0 - stampa \"*\" in orizzontale\n1 - stampa \"#\" in verticale\nSeleziona: ");
                // si usa parseInt (se si mette solo Scanner.nextInt potrà funzionare, ma se da "Exception" Scanner si "autochiude" e non funziona più)
                select=Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Errore durante l'inserimento, probabilmente il numero inserito è in un formato incorretto");
            }
        } while (select<0||select>1);
        String selectionString="";
        if(select==0){
            selectionString="*".repeat(voto0)+"\n"+"*".repeat(voto1);
        }else{
            for (int i = Math.max(voto0,voto1); i>=0; i--) {
                selectionString+="#\n";
            }
            selectionString+="# #\n".repeat(Math.min(voto0,voto1));
        }
        System.out.println(selectionString);
    }
}