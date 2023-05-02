import mylib.*;

/**
 * Classe che contiene tutte le costanti utili nel programma e
 * le funzioni che servono prima d'inizializzare un menu
 */
public abstract class Utility {
    public static final int LIV_MAX_SODDISFAZIONE = 100;
    public static final int LIV_MAX_SAZIETA = 100;
    public static final int LIV_MIN_SAZIETA_SODDISFAZIONE = 0;//la costante è la stessa perché non avrebbe senso un tamagotchi con sazietà e soddisfazione negativi
    public static final int LIV_FELICITA = 75;
    public static final int LIV_INFELICITA = 30;
    public static final int LIV_NAUSEA = 90;//sopra a questo valore il tama è triste perché ha mangiato troppo
    public static final int MAX_BISCOTTI = 5;
    public static final int MAX_CAREZZE = 5;
    public static final String SALUTO = "BENVENUTO NEL FANTASTICO MONDO DEI TAMAGOTCHI!!";

    /**
     * Crea un Tamagotchi chiedendo all'utente le sue caratteristiche all'inizio del programma
     * @return il Tamagotchi creato
     */
    public static Tamagotchi crea_tamagotchi(){
        System.out.println("Creiamo il tuo Tamagotchi!");
        String nome = InputData.readNonEmptyString("Qual è il suo nome?\n>\t", true);
        double sazieta = InputData.readDoubleBetween("Quanto è sazio attualmente? (da "+LIV_MIN_SAZIETA_SODDISFAZIONE+" a "+LIV_MAX_SAZIETA+")\n>\t", LIV_MIN_SAZIETA_SODDISFAZIONE, LIV_MAX_SAZIETA);
        double soddisfazione = InputData.readDoubleBetween("Quanto è felice? (da "+LIV_MIN_SAZIETA_SODDISFAZIONE+" a "+LIV_MAX_SODDISFAZIONE+")\n>\t", LIV_MIN_SAZIETA_SODDISFAZIONE, LIV_MAX_SODDISFAZIONE);
        return new Tamagotchi(nome,sazieta,soddisfazione);
    }

    /**
     * Stampa un saluto abbellito e colorato
     */
    public static void stampa_saluto(){
        System.out.println(AnsiColors.BLUE + PrettyStrings.frame(SALUTO, SALUTO.length(), false, true) + AnsiColors.RESET);
    }
}
