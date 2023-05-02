import it.kibo.fp.lib.*;
public class Tamagotchi {
    private final String nome;
    private double sazieta;
    private double soddisfazione;
    private boolean vita;//serve solo per controllare se chiudere il programma
    public Tamagotchi(String nome, double sazieta, double soddisfazione) {
        this.nome = nome;
        this.sazieta = sazieta;
        this.soddisfazione = soddisfazione;
        this.vita = true;//è vivo all'inizio
    }

    public boolean isVita() {
        return vita;
    }

    /**
     * Modifica i valori di sazietà e soddisfazione in base al numero di carezze ricevute
     * @param n numero di carezze generato casualmente
     */
    public void ricevi_carezze(int n){
        System.out.println("Biscotti ricevuti:"+n);
        soddisfazione= Math.min(soddisfazione+n, Utility.LIV_MAX_SODDISFAZIONE);
        sazieta= Math.max(sazieta-(double)n/2, Utility.LIV_MIN_SAZIETA_SODDISFAZIONE);
    }
    /**
     * Modifica i valori di sazietà e soddisfazione in base al numero di biscotti ricevuti
     * @param n numero di biscotti generato casualmente
     */
    public void ricevi_biscotti(int n){
        System.out.println("Biscotti ricevuti:"+n);
        for(int i=0;i<n;i++)
            sazieta= Math.min(sazieta+sazieta/10, Utility.LIV_MAX_SAZIETA);
        soddisfazione= Math.max(soddisfazione-(double)n/4, Utility.LIV_MIN_SAZIETA_SODDISFAZIONE);
    }

    /**
     * Se è morto stampa un messaggio di morte
     * altrimenti stampa un messaggio da parte
     * del Tamagotchi stesso che descrive come
     * si sente in base alle sue condizioni
     */
    public void controllo_condizioni(){
        if(!vita){}//se è morto non stampa nulla sulle sue condizioni
        else if(sazieta <= Utility.LIV_MIN_SAZIETA_SODDISFAZIONE || sazieta >= Utility.LIV_MAX_SAZIETA || soddisfazione <= Utility.LIV_MIN_SAZIETA_SODDISFAZIONE){
            vita = false;
            messaggio_morte();
        }
        else {
            System.out.println(this);
            String messaggio =(nome + ":\"");
            if (sazieta <= Utility.LIV_INFELICITA || soddisfazione <= Utility.LIV_INFELICITA || sazieta >= Utility.LIV_NAUSEA) {
                messaggio += ("Sono triste");
                if (sazieta >= Utility.LIV_NAUSEA) {
                    messaggio += (" perché mi hai fatto mangiare troppo");
                }
            } else if (sazieta >= Utility.LIV_FELICITA && soddisfazione >= Utility.LIV_FELICITA) {
                messaggio += ("Sto benissimo");
            } else {
                messaggio += ("Tutto ok");
            }
            messaggio += "\"";
            System.out.println(messaggio);
        }
    }

    /**
     * Stampa un breve messaggio di morte che
     * ti dice anche i motivi per cui è morto
     */
    public void messaggio_morte(){
        System.out.println("Purtroppo " + nome + " è morto\nMotivazioni:");
        if(sazieta<=Utility.LIV_MIN_SAZIETA_SODDISFAZIONE)
            System.out.println("È morto di inedia");
        if(soddisfazione<=Utility.LIV_MIN_SAZIETA_SODDISFAZIONE)
            System.out.println("È morto di solitudine");
        if(sazieta>=Utility.LIV_MAX_SAZIETA)
            System.out.println("Aveva mangiato troppo");
    }

    /**
     * Raccoglie in uno StringBuffer le caratteristiche del Tamagothi e poi
     * ritorna lo StringBuffer come stringa
     * @return una stringa con l'elenco delle caratteristiche del Tamagotchi
     */
    public String toString(){
        StringBuffer tama = new StringBuffer(AnsiColors.BLUE + PrettyStrings.isolatedLine("NOME: " + nome) + AnsiColors.RESET);
        tama.append("Livello sazieta:\t" + sazieta);
        tama.append("\nLivello soddisfazione:\t" + soddisfazione);

        return tama.toString();
    }

    /**
     * Chiede se l'utente è sicuro di uscire dal programma ed
     * eliminare il Tamagotchi e in quel caso lo registra come morto
     */
    public void termina_programma(){
        if(InputData.readYesOrNo("Vuoi davvero uccidere il tuo Tamagotchi"))
            vita=false;
    }
}
