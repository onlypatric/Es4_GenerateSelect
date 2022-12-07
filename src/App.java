import java.util.Scanner;

import pkg.util.RUtil;
/**
 * App
 */
public class App {

    public static void main(String[] args) {

        // importa pacchetto personale RUtil
        RUtil r = new RUtil();
        // Scanner per "int scelta"
        Scanner sc = new Scanner(System.in);

        // Genera random integer (random intero) compreso tra 1 e 10 estremi inclusi con il metodo randint
        int voto0 = r.randInt(1, 10);
        int voto1 = r.randInt(1, 10);
        // select = 2 così continua il loop nel dowhile in caso di input errato
        int select=2;
        do {
            try {
                //mostra all utente che fare
                System.out.print("Inserire un numero\n0 - stampa \"*\" in orizzontale\n1 - stampa \"#\" in verticale\nSeleziona: ");
                // si usa parseInt (se si mette solo Scanner.nextInt potrà funzionare, ma se da "Exception" Scanner si "autochiude" e non funziona più)
                select=Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                //fallback
                System.out.println("Errore durante l'inserimento, probabilmente il numero inserito è in un formato incorretto");
            }
        } while (select<0||select>1);
        // chiudi scanner perchè non serve più
        sc.close();
        // crea la stringa finale
        String selectionString="";
        if(select==0){
            // semplice, fare String.repeat(int) e ottenere i risultati in linea
            selectionString="*".repeat(voto0)+"\n"+"*".repeat(voto1);
        }else{
            // Parti stampando esclusivamente la differenza tra il voto massimo e minimo
            for (int i = Math.max(voto0,voto1)-Math.min(voto0,voto1); i>0; i--) {
                // usa +=, sarebbe come String0 = String0 + String1
                selectionString+="#\n";
            }
            // usa +=, sarebbe come String0 = String0 + String1,
            // con metodo repeat e parametro il voto minimo così da trovare il numero di # in comune
            selectionString+="# #\n".repeat(Math.min(voto0,voto1));
        }
        //stampa output e relativi numeri in ordine crescente
        System.out.println(selectionString);
        System.out.println(Math.max(voto0,voto1)+" "+Math.min(voto0,voto1));
    }
}