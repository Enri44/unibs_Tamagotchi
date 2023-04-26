import it.kibo.fp.lib.*;

public abstract class Utility {
    public static final int LIVELLO_MAX_SODDISFAZIONE = 100;
    public static final int LIVELLO_MAX_SAZIETA = 100;
    public static final int LIVELLO_MINIMO = 0;
    public static final int LIVELLO_FELICITA = 75;
    public static final int LIVELLO_INFELICITA = 30;
    public static final int LIVELLO_OBESITA = 90;
    public static final int MAX_BISCOTTI = 5;
    public static final int MAX_CAREZZE = 5;
    public static final String SALUTO = "BENVENUTO NEL FANTASTICO MONDO DEI TAMAGOTCHI!!";
    public static Tamagotchi crea_tamagotchi(){
        System.out.println("\nCreiamo la tua creatura!");
        String nome = InputData.readNonEmptyString("\nQual è il suo nome?\n>\t", true);
        double sazieta = InputData.readDoubleBetween("\nQuanto è sazio attualmente?\n>\t", (double)LIVELLO_MINIMO, (double)LIVELLO_MAX_SAZIETA);
        double soddisfazione = InputData.readDoubleBetween("\nQuanto è chilling?\n>\t", (double)LIVELLO_MINIMO, (double)LIVELLO_MAX_SODDISFAZIONE);
        return new Tamagotchi(nome,sazieta,soddisfazione);
    }

    public static void stampa_saluto(){
        System.out.println(AnsiColors.BLUE + PrettyStrings.frame(SALUTO, 20, true, true) + AnsiColors.RESET);
    }
}
