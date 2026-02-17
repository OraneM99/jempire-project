public class Main {
    private static void showRessources(Ressources r) {
        System.out.println("Vos ressources: ");
        System.out.println("Bois : " + r.getBois());
        System.out.println("Pierre : " + r.getPierre());
        System.out.println("Or : " + r.getOr());
        System.out.println("Nourriture : " + r.getNourriture());
        System.out.println("Habitants : " + r.getHabitants());
    }

    public static void main(String[] args) {
        showRessources(new Ressources());
    }
}
