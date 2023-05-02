public class Main {
    public static void main(String[] args) {
        Utility.stampa_saluto();
        MenuPrincipale p1 = new MenuPrincipale();
        p1.interazione(Utility.crea_tamagotchi());
        }
    }