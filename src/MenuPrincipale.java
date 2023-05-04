import mylib.*;

/**
 * Classe che inizializza subito un menu di opzioni di cosa fare
 * col Tamagotchi e contiene il metodo per interagire direttamente
 * con esso tramite i metodi stessi del Tamagotchi
 */
public class MenuPrincipale {
    private final String[] opzioni = {"Nutri", "Accarezza"};//le due scelte del menu da inserire in esso
    /*
     * La classe Menu importata richiede un titolo, una
     * lista di opzioni, se usare l'exit, se centrare il
     * titolo e se usare anche la parte verticale della cornice
     */
    Menu menu = new Menu("Cosa vuoi fare col tuo animaletto?", opzioni, true, true, true);

    public MenuPrincipale() {
    }

    /**
     * Richiede all'utente cosa vuole fare col Tamagotchi
     * e utilizza gli altri metodi per svolgere i comandi
     * @param tama il Tamagotchi sul quale verranno eseguiti i comandi
     */
    public void interazione(Tamagotchi tama){
        while(tama.isVita()) {//se muore non ci puoi fare più niente e finisce la tua interazione con lui
            int scelta = menu.choose();
            switch (scelta) {
                case 1 -> {
                    //genera un numero casuale tra 1 e 100, poi lo trasforma in un numero tra uno e il numero massimo di biscotti
                    int caso = (int) ((Math.random()*100) % Utility.MAX_BISCOTTI) + 1;
                    tama.ricevi_biscotti(caso);
                }
                case 2 -> {
                    int caso = (int) ((Math.random()*100) % Utility.MAX_CAREZZE) + 1;
                    tama.ricevi_carezze(caso);
                }
                case 0 -> tama.termina_programma();
                default -> {

                }
            }
            tama.controllo_condizioni();//ti stampa la situazione del tuo Tamagotchi prima di chiederti nuovamente cosa ci vuoi fare
            //se è morto qui viene stampato il messaggio di morte e il ciclo while non continua
        }
    }
}
