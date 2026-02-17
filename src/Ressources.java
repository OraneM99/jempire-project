public class Ressources {
    private int bois;
    private int pierre;
    private int or;
    private int nourriture;
    private int habitants;

    public Ressources () {
        this.bois = 0;
        this.pierre = 0;
        this.or = 50;
        this.nourriture = 100;
        this.habitants = 1;
    }

    public int getBois() {return  bois;}

    public int getPierre() {return pierre;}

    public int getOr() {return or;}

    public int getNourriture() {return nourriture;}

    public int getHabitants() {return habitants;}

    public void setBois(int bois) {this.bois = bois;}

    public void setPierre(int pierre) {this.pierre = pierre;}

    public void setOr(int or) {this.or = or;}

    public void setNourriture(int nourriture) {this.nourriture = nourriture;}

    public void setHabitants(int habitants) {this.habitants = habitants;}
}
