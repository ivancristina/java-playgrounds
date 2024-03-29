//import prog*io.*;

// Librerie necessarie
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import static java.lang.System.*;


public class program {      // classe principale
    public static void main(String[] args) {

        out.println("***********************************");
        out.println("Funzioni base Java di Ivan Cristina");
        out.println("***********************************");
        setup.help();   // Richiama funzione help in classe setup

    }
}

class setup {

    // private per essere chiamabili solo all'interno della classe;
    // static per essere chiamabili in tutta la classe;
    // final a causa dello switch che necessita di variabili costanti
    private static final String funz1 = "print";
    private static final String funz2 = "operations";
    private static final String funz3 = "console";
    private static final String funz4 = "ifcondititon";
    private static final String funz5 = "primo";
    private static final String funz6 = "rand_array";
    private static final String funz7 = "log_curve";
    private static final String funz8 = "cesare";
    private static final String funz9 = "vigenere";

    private static final String funze = "esci";


    static void help() {

        String spazi = "                   ";

        out.println("Elenco delle funzioni:");
        out.print("\n");
        // Eventualmente fisserò numero di spazi tramite differenza lenght parole
        out.println("1:  " + funz1 + spazi.substring(0, spazi.length() - funz1.length()) + "Test di print");
        out.println("2:  " + funz2 + spazi.substring(0, spazi.length() - funz2.length()) + "Operazioni con due valori");
        out.println("3:  " + funz3 + spazi.substring(0, spazi.length() - funz3.length()) + "RW Console");
        out.println("4:  " + funz4 + spazi.substring(0, spazi.length() - funz4.length()) + "Esegui una condizione SE");
        out.println("5:  " + funz5 + spazi.substring(0, spazi.length() - funz5.length()) + "Verifica numero primo");
        out.println("6:  " + funz6 + spazi.substring(0, spazi.length() - funz6.length()) + "Lancia una moneta");
        out.println("7:  " + funz7 + spazi.substring(0, spazi.length() - funz7.length()) + "Curva logaritmica");
        out.println("8:  " + funz8 + spazi.substring(0, spazi.length() - funz8.length()) + "Cifrario di Cesare");
        out.println("9:  " + funz9 + spazi.substring(0, spazi.length() - funz9.length()) + "Cifrario di Vigenere");

        out.println("E:  " + funze + spazi.substring(0, spazi.length() - funze.length()) + "Chiudi il programma");
        out.print("\n");
        setup.menu();
    }

    private static void menu() {

        out.println("Scegli uno dei menu, tramite numero o nome funzione:");
        out.print("\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String nome = null; // Inizializza la funzione, anche con un null
        try {
            nome = reader.readLine();       // Legge l'input di console
        } catch (IOException e) {           // Evita di usare IOException globalmente
            e.printStackTrace();
        }
        out.print("\n");

        /*
        // Metodo 1 - getRuntime
        // Teroricamente corretto, non funziona a causa della natura di Runtime

        try {
            Runtime.getRuntime().exec(funzione);
        } catch (IOException e) {
            System.out.println(funzione);
            e.printStackTrace();
        }

        // Metodo 2 - Reflection
        // Potrebbe funzionare, preferibile a case in questo programma. WIP

        String funzione = "funzioni." + nome + "();";

        try {
            Class.forName("funzioni").getDeclaredMethod(nome, null);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        */

        // Metodo 3 - switch case
        assert nome != null;    // Evita una NullPointerException
        switch (nome) {
            case funz1:         // Possiamo utilizzare più di
            case "1":           // una condizione per un caso
                out.println("Apro la funzione: " + funz1);
                funzioni.print();
                break;
            case funz2:
            case "2":
                out.println("Apro la funzione: " + funz2);
                funzioni.addizione();
                break;
            case funz3:
            case "3":
                out.println("Apro la funzione: " + funz3);
                funzioni.console();
                break;
            case funz4:
            case "4":
                out.println("Apro la funzione: " + funz4);
                funzioni.ifcondition();
                break;
            case funz5:
            case "5":
                out.println("Apro la funzione: " + funz5);
                funzioni.primo();
                break;
            case funz6:
            case "6":
                out.println("Apro la funzione: " + funz6);
                funzioni.rand_array();
                break;
            case funz7:
            case "7":
                out.println("Apro la funzione: " + funz7);
                funzioni.log_curve();
                break;
            case funz8:
            case "8":
                out.println("Apro la funzione: " + funz8);
                funzioni.cesare();
                break;
            case funz9:
            case "9":
                out.println("Apro la funzione: " + funz9);
                funzioni.vigenere();
                break;
            case funze:
            case "E":
            case "e":
                setup.esci();
                break;
            default:    // caso avviato in cui condizione in input inesistente
                out.println("Funzione non contemplata. Riapro setup");
                setup.help();

                out.print("\n");

        }

    }

    static void fine() {        // si avvia alla fine di ogni funzione
        out.print("\n");
        out.print("Premi m per tornare al menu, e per uscire");
        out.print("\n");
        out.print("\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String scelta = null;
        try {
            scelta = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("\n");
        assert scelta != null;
        if(scelta.equals("m")){
            setup.help();
        }else if(scelta.equals("e")){
            setup.esci();
        }else{
            out.println("Scelta non contemplata. Riapro il menu");
            setup.fine();
        }
    }

    private static void esci() {

        out.println("Esco dal programma");
        out.println("\"Let me sleep.\" - Al Pacino");
        out.print("\n");
        exit(0);
    }
}

class funzioni {

    private static double x;    // Private to make it avaiable to the entire class,
    private static double y;    // better than make it public to prevent confusion
    private static String input = null;

    static void print() {

        out.println("*************");
        out.println("\"Escape room\"\n    Hello");
        out.println("*************");
        setup.fine();
    }

    static void addizione() {
        funzioni.read();

        double sum = x + y;
        double dif = x - y;    // Also x ^ y
        double mol = x * y;
        int div = (int) (x / y);
        int rst = (int) (x % y);
        double pwr = Math.pow(x, y);  // Power should be a double, but I want it as an int
        double log = (Math.log(x) / (Math.log(y))); // Logarithm of x to the base of y

        out.print("\n");
        out.print("X: " + x + " è ");
        if (x>0) out.println("positivo!");
        else out.println("negativo!");
        out.print("Y: " + y + " è ");
        if (y>0) out.println("positivo!");
        else out.println("negativo!");

        out.print("X (" + x + ") è ");
        if (x>y) out.print("maggiore");
        else out.print("minore");
        out.println(" di Y (" + y + ")!");

        out.println(x + " plus " + y + " is " + sum);
        out.println(x + " minus " + y + " is " + dif);
        out.println(x + " times " + y + " is " + mol);
        out.println(x + " divided by " + y + " is " + div + ". The rest is " + rst + ". Exact result is " + (x/y));
        out.println(x + " to the power of " + y + " is " + pwr);
        out.println("Logarithm of " + x + " in base " + y + " - log"+x+"("+y+") - is " + log);

        setup.fine();

    }

    static void console() {
        out.print("Scrivi qualcosa qui:");
        out.print("\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert input != null;
        out.println("Hai scritto \"" + input + "\"");            // Rilegge il valore
        out.println("In maiuscolo: " + input.toUpperCase() );    // Maiuscolo
        out.println("In minuscolo: " + input.toLowerCase() );    // Minuscolo
        out.println("Lunghezza parola: " + input.length() );     // Lunghezza
        if (input.length()>4){
            out.println("Substring(2,5): " + input.substring(2,5) );
        }else{      // Substring se parola con più di 5(+1) caratteri
            out.println("Per Substring, scegli una parola con 5 o più caratteri");
        }

        out.println("Contiene lettera \"a\": " + input.contains("a"));

        for (int i = 0; i < input.length(); i++){
            out.println("La lettera alla posizione " + i + " è " + input.substring(i,i+1) );
        }

        setup.fine();

    }

    static void ifcondition() {
        out.print("Hai più di €5000 in banca? (s/n)");
        out.print("\n");
        out.print("\n");

        funzioni.input();
        out.print("\n");

        if (input.equals("n")){
            out.println("Sei un poraccio");
        }else if (input.equals("s")){
            out.println("Dona tutto alla Caritas infame");
        }else{
            out.println("Non ho capito. Rispondi con \"s\" o \"n\"");
        }
        setup.fine();

    }

    static void primo() {
        out.print("\n");
        out.print("Digita un numero:");
        out.print("\n");
        funzioni.input();

        int numero = Integer.parseInt(input);
        boolean primo = false;
        for(int i = 2; i <= numero/2; ++i)
        // Verifica tutti i possibili divisori (fino alla metà del numero stesso) in ciclo for
        {
            // Verifica dell'operatore residuo. Se il resto è 0, il numero è primo
            if(numero % i == 0)
            {
                primo = true;
                break;
            }
        }
        if (!primo)
            out.println(numero + " è un numero primo!");
        else
            out.println(numero + " non è un numero primo!");
        setup.fine();
    }

    static void rand_array() {
        out.println("Inserisci il numero di lanci");
        out.print("\n");
        funzioni.input();
        out.print("\n");

        int lanci = Integer.parseInt(input);
        int conteggio = 0;

        out.println("Lancio una moneta " + lanci + " volte");
        out.print("\n");

        Random valori = new Random();       // inizializzo il generatore

        for (int i = 0; i < lanci; i++){
            boolean faccia = valori.nextBoolean();      // testa o croce è un valore booleano
            if(faccia){             // se il valore è positivo
                out.println("Testa");
                conteggio++;        // aumenta il contatore
            }else if (!faccia){     // se il valore è negativo
                out.println("Croce");
            }
        }

        int teste = conteggio;
        int croci = (lanci-conteggio);
        double percT = (100 * (double) teste) / lanci;  // proporzione
        double percC = (100 * (double) croci) / lanci;

        out.print("\n");
        out.println("Teste: " + teste + ", Croci: " + croci);
        out.println("Percentuale T: " + percT + "%, Percentuale C: " + percC + "%");

        setup.fine();
    }

    static void log_curve() {
        out.print("\n");
        out.print("Digita un numero:");
        out.print("\n");
        funzioni.input();

        // to be completed later

        setup.fine();
    }

    static void cesare() {
        out.print("\n");
        out.print("Digita una frase:");
        out.print("\n");
        funzioni.input();
        String frase = input;

        out.print("\n");
        out.print("Inserisci l'offeset k:");
        out.print("\n");
        funzioni.input();
        int k = Integer.parseInt(input);

        out.print("\n");
        out.print("Scegli se cifrare (c) o decifrare (d):");
        out.print("\n");
        funzioni.input();
        String cifdef = null;
        if (input.equals("c")){
            cifdef = "cifrata";
        }else if (input.equals("d")){
            cifdef = "decifrata";
            k = -k;
        }else{
            out.print("Non capisco. Ricomincio");
            funzioni.cesare();
        }

        String finale = null;
        String part = "";

        for (int i = 0; i < frase.length(); i++) {
            char character = frase.charAt(i);
            int ascii = (int) character;
            int newascii = ascii + k;
            String l = Character.toString(newascii);
            finale = (part + l);
            part = finale;
        }

        out.print("\n");
        out.println("La frase " + cifdef + " con k=" + k + " è: \"" + finale + "\"");

        setup.fine();
    }

    static void vigenere() {
        out.print("\n");
        out.print("Digita una frase:");
        out.print("\n");
        funzioni.input();
        String frase = input;

        out.print("\n");
        out.print("Inserisci la parola k:");
        out.print("\n");
        funzioni.input();
        String k = input;

        out.print("\n");
        out.print("Scegli se cifrare (c) o decifrare (d):");
        out.print("\n");
        funzioni.input();
        String cifdef = null;
        boolean c = false;
        if (input.equals("c")){
            cifdef = "cifrata";
            c = true;
        }else if (input.equals("d")){
            cifdef = "decifrata";
            c = false;
        }else{
            out.print("Non capisco. Ricomincio");
            funzioni.vigenere();
        }

        String finale = null;
        String part = "";
        int newascii = 0;
        int p=0;

        for (int f = 0; f < frase.length(); f++) {
            char f_character = frase.charAt(f);
            char p_character = k.charAt(p);
            int f_ascii = (int) f_character;
            int p_ascii = ((int) p_character) - 96;
            if (c) newascii = f_ascii + p_ascii;
            else newascii = f_ascii - p_ascii;
            char l = (char)newascii;
            // String l = Character.toString(newascii);
            finale = (part + l);
            part = finale;
            p++;
            if (p >= k.length()){
                p=0;
            }
        }

        out.print("\n");
        out.println("La frase " + cifdef + " con k=\"" + k + "\" è: \"" + finale + "\"");

        setup.fine();
    }

    private static void input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert null != input;

    }

    private static void read() {
        out.print("\n");     // A causa della chiamata della funzione in switch

        // X
        out.print("Inserisci valore di x");
        out.print("\n");
        BufferedReader xread = new BufferedReader(new InputStreamReader(in));
        String x1 = null;
        try {
            x1 = xread.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert x1 != null;
        x = Double.parseDouble(x1);

        // Y
        out.print("Inserisci valore di y");
        out.print("\n");
        BufferedReader yread = new BufferedReader(new InputStreamReader(in));
        String y1 = null;
        try {
            y1 = yread.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert y1 != null;
        y = Double.parseDouble(y1);

    }
}