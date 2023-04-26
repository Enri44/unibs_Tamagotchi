import it.kibo.fp.lib.*;
public class Tamagotchi {

    private String nome;
    private double sazieta;
    private double soddisfazione;

    private boolean vita;

    public Tamagotchi(String nome, double sazieta, double soddisfazione) {
        this.nome = nome;
        this.sazieta = sazieta;
        this.soddisfazione = soddisfazione;
        this.vita = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSazieta() {
        return sazieta;
    }

    public void setSazieta(double sazieta) {
        this.sazieta = sazieta;
    }

    public double getSoddisfazione() {
        return soddisfazione;
    }

    public void setSoddisfazione(double soddisfazione) {
        this.soddisfazione = soddisfazione;
    }

    public boolean isVita() {
        return vita;
    }

    public void setVita(boolean vita) {
        this.vita = vita;
    }

    public void ricevi_carezze(int n){
        soddisfazione += n;
        sazieta -= (double) n/2;
    }

    public void ricevi_biscotti(int n){
        sazieta += (double)n /5;
        soddisfazione -= (double)n/4;
    }

    public void controllo_condizioni(){
        if(sazieta <= Utility.LIVELLO_MINIMO || sazieta >= Utility.LIVELLO_MAX_SAZIETA || soddisfazione <= Utility.LIVELLO_MINIMO){
            vita = false;
            messaggio_morte();
        }
        else if(sazieta <= Utility.LIVELLO_INFELICITA || soddisfazione <= Utility.LIVELLO_INFELICITA || sazieta >= Utility.LIVELLO_OBESITA){
            System.out.println("\n" + nome + ":\n> All around me are familiar faces\n> worn out faces\n> worn out placeeees!");
        }
        else if(sazieta >= Utility.LIVELLO_FELICITA && soddisfazione >= Utility.LIVELLO_FELICITA){
            System.out.println("\n" + nome + ":\n> Life is good!");
        }
        else{System.out.println("\n" + nome + ":\n> Almeno sono vivo...");}
        if(sazieta >= Utility.LIVELLO_OBESITA){
            System.out.println(":\n> E sono letteralmente obeso!");
        }
    }
    public void messaggio_morte(){
        if(!vita){ System.out.println("Mannagg alla maronna è mortu lu " + nome);}
    }

    public String toString(){
        StringBuffer tama = new StringBuffer("\n" + PrettyStrings.isolatedLine(nome));
        tama.append("\nLivello sazieta:\t" + sazieta);
        tama.append("\nLivello soddisfazione:\t" + soddisfazione);

        return tama.toString();
    }

    public void ricevi_botte(){
        int caso = (int)Math.random()%3 +1;
    }
    public void ricevi_pizza_con_ananas(){

    }
}
