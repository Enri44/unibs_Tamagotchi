import it.kibo.fp.lib.*;

import java.util.ArrayList;

public class MenuPrincipale {
    private final String[] opzioni = {"Nutri", "Accarezza", "Picchia", "Crimine contro l'umanità"};
    Menu menu = new Menu("Cosa vuoi fare con tuo figlio?", opzioni, true, true, true);

    public MenuPrincipale() {
    }

    public void interazione(Tamagotchi tama){
        int scelta = menu.choose();
        switch (scelta){
            case 1 -> {
                int caso = (int)Math.random() % Utility.MAX_BISCOTTI + 1;
                tama.ricevi_biscotti(caso);
            }
            case 2 -> {
                int caso = (int)Math.random() % Utility.MAX_CAREZZE + 1;
                tama.ricevi_carezze(caso);
            }
            case 3 -> {

            }
            case 4 -> {

            }
            default -> {

            }
        }
    }
}
